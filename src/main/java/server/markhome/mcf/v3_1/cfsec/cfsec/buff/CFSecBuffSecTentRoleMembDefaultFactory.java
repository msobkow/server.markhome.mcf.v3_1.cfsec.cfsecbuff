
// Description: Java 25 Default Factory implementation for SecTentRoleMemb buffers

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
 *	CFSecBuffSecTentRoleMembFactory implementation of ICFSecSecTentRoleMembFactory for SecTentRoleMemb
 */
public class CFSecBuffSecTentRoleMembDefaultFactory
	implements ICFSecSecTentRoleMembFactory
{
	public CFSecBuffSecTentRoleMembDefaultFactory() {
	}

    @Override
    public ICFSecSecTentRoleMembPKey newPKey() {
        ICFSecSecTentRoleMembPKey pkey =
            new CFSecBuffSecTentRoleMembPKey();
        return( pkey );
    }

	public CFSecBuffSecTentRoleMembPKey ensurePKey(ICFSecSecTentRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleMembPKey) {
			return( (CFSecBuffSecTentRoleMembPKey)key );
		}
		else {
			CFSecBuffSecTentRoleMembPKey mapped = new CFSecBuffSecTentRoleMembPKey();
			mapped.setRequiredContainerRole( key.getRequiredSecTentRoleId() );
			mapped.setRequiredParentUser( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleMembHPKey newHPKey() {
		ICFSecSecTentRoleMembHPKey hpkey =
			new CFSecBuffSecTentRoleMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecTentRoleMembHPKey ensureHPKey(ICFSecSecTentRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecTentRoleMembHPKey) {
			return( (CFSecBuffSecTentRoleMembHPKey)key );
		}
		else {
			CFSecBuffSecTentRoleMembHPKey mapped = new CFSecBuffSecTentRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleMembByTentRoleIdxKey newByTentRoleIdxKey() {
		ICFSecSecTentRoleMembByTentRoleIdxKey key =
			new CFSecBuffSecTentRoleMembByTentRoleIdxKey();
		return( key );
	}

	public CFSecBuffSecTentRoleMembByTentRoleIdxKey ensureByTentRoleIdxKey(ICFSecSecTentRoleMembByTentRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleMembByTentRoleIdxKey) {
			return( (CFSecBuffSecTentRoleMembByTentRoleIdxKey)key );
		}
		else {
			CFSecBuffSecTentRoleMembByTentRoleIdxKey mapped = new CFSecBuffSecTentRoleMembByTentRoleIdxKey();
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleMembByUserIdxKey newByUserIdxKey() {
		ICFSecSecTentRoleMembByUserIdxKey key =
			new CFSecBuffSecTentRoleMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecTentRoleMembByUserIdxKey ensureByUserIdxKey(ICFSecSecTentRoleMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentRoleMembByUserIdxKey) {
			return( (CFSecBuffSecTentRoleMembByUserIdxKey)key );
		}
		else {
			CFSecBuffSecTentRoleMembByUserIdxKey mapped = new CFSecBuffSecTentRoleMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleMemb newRec() {
		ICFSecSecTentRoleMemb rec =
			new CFSecBuffSecTentRoleMemb();
		return( rec );
	}

	public CFSecBuffSecTentRoleMemb ensureRec(ICFSecSecTentRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecTentRoleMemb) {
			return( (CFSecBuffSecTentRoleMemb)rec );
		}
		else {
			CFSecBuffSecTentRoleMemb mapped = new CFSecBuffSecTentRoleMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentRoleMembH newHRec() {
		ICFSecSecTentRoleMembH hrec =
			new CFSecBuffSecTentRoleMembH();
		return( hrec );
	}

	public CFSecBuffSecTentRoleMembH ensureHRec(ICFSecSecTentRoleMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecTentRoleMembH) {
			return( (CFSecBuffSecTentRoleMembH)hrec );
		}
		else {
			CFSecBuffSecTentRoleMembH mapped = new CFSecBuffSecTentRoleMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
