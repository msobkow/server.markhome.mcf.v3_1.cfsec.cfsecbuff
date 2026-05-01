
// Description: Java 25 Default Factory implementation for SecTentRole buffers

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
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffSecTentRoleFactory implementation of ICFSecSecTentRoleFactory for SecTentRole
 */
public class CFSecBuffSecTentRoleDefaultFactory
	implements ICFSecSecTentRoleFactory
{
	public CFSecBuffSecTentRoleDefaultFactory() {
	}

	@Override
	public ICFSecSecTentRoleHPKey newHPKey() {
		ICFSecSecTentRoleHPKey hpkey =
			new CFSecBuffSecTentRoleHPKey();
		return( hpkey );
	}

	public CFSecBuffSecTentRoleHPKey ensureHPKey(ICFSecSecTentRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecTentRoleHPKey) {
			return( (CFSecBuffSecTentRoleHPKey)key );
		}
		else {
			CFSecBuffSecTentRoleHPKey mapped = new CFSecBuffSecTentRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleByTenantIdxKey newByTenantIdxKey() {
		ICFSecSecTentRoleByTenantIdxKey key =
			new CFSecBuffSecTentRoleByTenantIdxKey();
		return( key );
	}

	public CFSecBuffSecTentRoleByTenantIdxKey ensureByTenantIdxKey(ICFSecSecTentRoleByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleByTenantIdxKey) {
			return( (CFSecBuffSecTentRoleByTenantIdxKey)key );
		}
		else {
			CFSecBuffSecTentRoleByTenantIdxKey mapped = new CFSecBuffSecTentRoleByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleByNameIdxKey newByNameIdxKey() {
		ICFSecSecTentRoleByNameIdxKey key =
			new CFSecBuffSecTentRoleByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecTentRoleByNameIdxKey ensureByNameIdxKey(ICFSecSecTentRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleByNameIdxKey) {
			return( (CFSecBuffSecTentRoleByNameIdxKey)key );
		}
		else {
			CFSecBuffSecTentRoleByNameIdxKey mapped = new CFSecBuffSecTentRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecTentRoleByUNameIdxKey key =
			new CFSecBuffSecTentRoleByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecTentRoleByUNameIdxKey ensureByUNameIdxKey(ICFSecSecTentRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleByUNameIdxKey) {
			return( (CFSecBuffSecTentRoleByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecTentRoleByUNameIdxKey mapped = new CFSecBuffSecTentRoleByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRole newRec() {
		ICFSecSecTentRole rec =
			new CFSecBuffSecTentRole();
		return( rec );
	}

	public CFSecBuffSecTentRole ensureRec(ICFSecSecTentRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecTentRole) {
			return( (CFSecBuffSecTentRole)rec );
		}
		else {
			CFSecBuffSecTentRole mapped = new CFSecBuffSecTentRole();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleH newHRec() {
		ICFSecSecTentRoleH hrec =
			new CFSecBuffSecTentRoleH();
		return( hrec );
	}

	public CFSecBuffSecTentRoleH ensureHRec(ICFSecSecTentRoleH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecTentRoleH) {
			return( (CFSecBuffSecTentRoleH)hrec );
		}
		else {
			CFSecBuffSecTentRoleH mapped = new CFSecBuffSecTentRoleH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
