
// Description: Java 25 Default Factory implementation for TSecGroup buffers

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
 *	CFSecBuffTSecGroupFactory implementation of ICFSecTSecGroupFactory for TSecGroup
 */
public class CFSecBuffTSecGroupDefaultFactory
	implements ICFSecTSecGroupFactory
{
	public CFSecBuffTSecGroupDefaultFactory() {
	}

	@Override
	public ICFSecTSecGroupHPKey newHPKey() {
		ICFSecTSecGroupHPKey hpkey =
			new CFSecBuffTSecGroupHPKey();
		return( hpkey );
	}

	public CFSecBuffTSecGroupHPKey ensureHPKey(ICFSecTSecGroupHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffTSecGroupHPKey) {
			return( (CFSecBuffTSecGroupHPKey)key );
		}
		else {
			CFSecBuffTSecGroupHPKey mapped = new CFSecBuffTSecGroupHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredTSecGroupId( key.getRequiredTSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGroupByTenantIdxKey newByTenantIdxKey() {
		ICFSecTSecGroupByTenantIdxKey key =
			new CFSecBuffTSecGroupByTenantIdxKey();
		return( key );
	}

	public CFSecBuffTSecGroupByTenantIdxKey ensureByTenantIdxKey(ICFSecTSecGroupByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGroupByTenantIdxKey) {
			return( (CFSecBuffTSecGroupByTenantIdxKey)key );
		}
		else {
			CFSecBuffTSecGroupByTenantIdxKey mapped = new CFSecBuffTSecGroupByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGroupByTenantVisIdxKey newByTenantVisIdxKey() {
		ICFSecTSecGroupByTenantVisIdxKey key =
			new CFSecBuffTSecGroupByTenantVisIdxKey();
		return( key );
	}

	public CFSecBuffTSecGroupByTenantVisIdxKey ensureByTenantVisIdxKey(ICFSecTSecGroupByTenantVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGroupByTenantVisIdxKey) {
			return( (CFSecBuffTSecGroupByTenantVisIdxKey)key );
		}
		else {
			CFSecBuffTSecGroupByTenantVisIdxKey mapped = new CFSecBuffTSecGroupByTenantVisIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredIsVisible( key.getRequiredIsVisible() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGroupByUNameIdxKey newByUNameIdxKey() {
		ICFSecTSecGroupByUNameIdxKey key =
			new CFSecBuffTSecGroupByUNameIdxKey();
		return( key );
	}

	public CFSecBuffTSecGroupByUNameIdxKey ensureByUNameIdxKey(ICFSecTSecGroupByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGroupByUNameIdxKey) {
			return( (CFSecBuffTSecGroupByUNameIdxKey)key );
		}
		else {
			CFSecBuffTSecGroupByUNameIdxKey mapped = new CFSecBuffTSecGroupByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGroup newRec() {
		ICFSecTSecGroup rec =
			new CFSecBuffTSecGroup();
		return( rec );
	}

	public CFSecBuffTSecGroup ensureRec(ICFSecTSecGroup rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffTSecGroup) {
			return( (CFSecBuffTSecGroup)rec );
		}
		else {
			CFSecBuffTSecGroup mapped = new CFSecBuffTSecGroup();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGroupH newHRec() {
		ICFSecTSecGroupH hrec =
			new CFSecBuffTSecGroupH();
		return( hrec );
	}

	public CFSecBuffTSecGroupH ensureHRec(ICFSecTSecGroupH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffTSecGroupH) {
			return( (CFSecBuffTSecGroupH)hrec );
		}
		else {
			CFSecBuffTSecGroupH mapped = new CFSecBuffTSecGroupH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
