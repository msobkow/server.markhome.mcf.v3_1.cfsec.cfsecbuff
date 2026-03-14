
// Description: Java 25 Default Factory implementation for Tenant buffers

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsec.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffTenantFactory implementation of ICFSecTenantFactory for Tenant
 */
public class CFSecBuffTenantDefaultFactory
	implements ICFSecTenantFactory
{
	public CFSecBuffTenantDefaultFactory() {
	}

	@Override
	public ICFSecTenantHPKey newHPKey() {
		ICFSecTenantHPKey hpkey =
			new CFSecBuffTenantHPKey();
		return( hpkey );
	}

	public CFSecBuffTenantHPKey ensureHPKey(ICFSecTenantHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffTenantHPKey) {
			return( (CFSecBuffTenantHPKey)key );
		}
		else {
			CFSecBuffTenantHPKey mapped = new CFSecBuffTenantHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantByClusterIdxKey newByClusterIdxKey() {
		ICFSecTenantByClusterIdxKey key =
			new CFSecBuffTenantByClusterIdxKey();
		return( key );
	}

	public CFSecBuffTenantByClusterIdxKey ensureByClusterIdxKey(ICFSecTenantByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTenantByClusterIdxKey) {
			return( (CFSecBuffTenantByClusterIdxKey)key );
		}
		else {
			CFSecBuffTenantByClusterIdxKey mapped = new CFSecBuffTenantByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantByUNameIdxKey newByUNameIdxKey() {
		ICFSecTenantByUNameIdxKey key =
			new CFSecBuffTenantByUNameIdxKey();
		return( key );
	}

	public CFSecBuffTenantByUNameIdxKey ensureByUNameIdxKey(ICFSecTenantByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTenantByUNameIdxKey) {
			return( (CFSecBuffTenantByUNameIdxKey)key );
		}
		else {
			CFSecBuffTenantByUNameIdxKey mapped = new CFSecBuffTenantByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredTenantName( key.getRequiredTenantName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenant newRec() {
		ICFSecTenant rec =
			new CFSecBuffTenant();
		return( rec );
	}

	public CFSecBuffTenant ensureRec(ICFSecTenant rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffTenant) {
			return( (CFSecBuffTenant)rec );
		}
		else {
			CFSecBuffTenant mapped = new CFSecBuffTenant();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantH newHRec() {
		ICFSecTenantH hrec =
			new CFSecBuffTenantH();
		return( hrec );
	}

	public CFSecBuffTenantH ensureHRec(ICFSecTenantH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffTenantH) {
			return( (CFSecBuffTenantH)hrec );
		}
		else {
			CFSecBuffTenantH mapped = new CFSecBuffTenantH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
