
// Description: Java 25 Default Factory implementation for SecTentGrp buffers

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
 *	CFSecBuffSecTentGrpFactory implementation of ICFSecSecTentGrpFactory for SecTentGrp
 */
public class CFSecBuffSecTentGrpDefaultFactory
	implements ICFSecSecTentGrpFactory
{
	public CFSecBuffSecTentGrpDefaultFactory() {
	}

	@Override
	public ICFSecSecTentGrpHPKey newHPKey() {
		ICFSecSecTentGrpHPKey hpkey =
			new CFSecBuffSecTentGrpHPKey();
		return( hpkey );
	}

	public CFSecBuffSecTentGrpHPKey ensureHPKey(ICFSecSecTentGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecTentGrpHPKey) {
			return( (CFSecBuffSecTentGrpHPKey)key );
		}
		else {
			CFSecBuffSecTentGrpHPKey mapped = new CFSecBuffSecTentGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpByTenantIdxKey newByTenantIdxKey() {
		ICFSecSecTentGrpByTenantIdxKey key =
			new CFSecBuffSecTentGrpByTenantIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpByTenantIdxKey ensureByTenantIdxKey(ICFSecSecTentGrpByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpByTenantIdxKey) {
			return( (CFSecBuffSecTentGrpByTenantIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpByTenantIdxKey mapped = new CFSecBuffSecTentGrpByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpByNameIdxKey newByNameIdxKey() {
		ICFSecSecTentGrpByNameIdxKey key =
			new CFSecBuffSecTentGrpByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpByNameIdxKey ensureByNameIdxKey(ICFSecSecTentGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpByNameIdxKey) {
			return( (CFSecBuffSecTentGrpByNameIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpByNameIdxKey mapped = new CFSecBuffSecTentGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecTentGrpByUNameIdxKey key =
			new CFSecBuffSecTentGrpByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpByUNameIdxKey ensureByUNameIdxKey(ICFSecSecTentGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpByUNameIdxKey) {
			return( (CFSecBuffSecTentGrpByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpByUNameIdxKey mapped = new CFSecBuffSecTentGrpByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrp newRec() {
		ICFSecSecTentGrp rec =
			new CFSecBuffSecTentGrp();
		return( rec );
	}

	public CFSecBuffSecTentGrp ensureRec(ICFSecSecTentGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecTentGrp) {
			return( (CFSecBuffSecTentGrp)rec );
		}
		else {
			CFSecBuffSecTentGrp mapped = new CFSecBuffSecTentGrp();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpH newHRec() {
		ICFSecSecTentGrpH hrec =
			new CFSecBuffSecTentGrpH();
		return( hrec );
	}

	public CFSecBuffSecTentGrpH ensureHRec(ICFSecSecTentGrpH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecTentGrpH) {
			return( (CFSecBuffSecTentGrpH)hrec );
		}
		else {
			CFSecBuffSecTentGrpH mapped = new CFSecBuffSecTentGrpH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
