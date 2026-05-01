
// Description: Java 25 Default Factory implementation for SecRoleMemb buffers

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
 *	CFSecBuffSecRoleMembFactory implementation of ICFSecSecRoleMembFactory for SecRoleMemb
 */
public class CFSecBuffSecRoleMembDefaultFactory
	implements ICFSecSecRoleMembFactory
{
	public CFSecBuffSecRoleMembDefaultFactory() {
	}

    @Override
    public ICFSecSecRoleMembPKey newPKey() {
        ICFSecSecRoleMembPKey pkey =
            new CFSecBuffSecRoleMembPKey();
        return( pkey );
    }

	public CFSecBuffSecRoleMembPKey ensurePKey(ICFSecSecRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleMembPKey) {
			return( (CFSecBuffSecRoleMembPKey)key );
		}
		else {
			CFSecBuffSecRoleMembPKey mapped = new CFSecBuffSecRoleMembPKey();
			mapped.setRequiredContainerRole( key.getRequiredSecRoleId() );
			mapped.setRequiredParentUser( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleMembHPKey newHPKey() {
		ICFSecSecRoleMembHPKey hpkey =
			new CFSecBuffSecRoleMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecRoleMembHPKey ensureHPKey(ICFSecSecRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecRoleMembHPKey) {
			return( (CFSecBuffSecRoleMembHPKey)key );
		}
		else {
			CFSecBuffSecRoleMembHPKey mapped = new CFSecBuffSecRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecRoleId( key.getRequiredSecRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleMembByRoleIdxKey newByRoleIdxKey() {
		ICFSecSecRoleMembByRoleIdxKey key =
			new CFSecBuffSecRoleMembByRoleIdxKey();
		return( key );
	}

	public CFSecBuffSecRoleMembByRoleIdxKey ensureByRoleIdxKey(ICFSecSecRoleMembByRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleMembByRoleIdxKey) {
			return( (CFSecBuffSecRoleMembByRoleIdxKey)key );
		}
		else {
			CFSecBuffSecRoleMembByRoleIdxKey mapped = new CFSecBuffSecRoleMembByRoleIdxKey();
			mapped.setRequiredSecRoleId( key.getRequiredSecRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleMembByLoginIdxKey newByLoginIdxKey() {
		ICFSecSecRoleMembByLoginIdxKey key =
			new CFSecBuffSecRoleMembByLoginIdxKey();
		return( key );
	}

	public CFSecBuffSecRoleMembByLoginIdxKey ensureByLoginIdxKey(ICFSecSecRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleMembByLoginIdxKey) {
			return( (CFSecBuffSecRoleMembByLoginIdxKey)key );
		}
		else {
			CFSecBuffSecRoleMembByLoginIdxKey mapped = new CFSecBuffSecRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleMemb newRec() {
		ICFSecSecRoleMemb rec =
			new CFSecBuffSecRoleMemb();
		return( rec );
	}

	public CFSecBuffSecRoleMemb ensureRec(ICFSecSecRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecRoleMemb) {
			return( (CFSecBuffSecRoleMemb)rec );
		}
		else {
			CFSecBuffSecRoleMemb mapped = new CFSecBuffSecRoleMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleMembH newHRec() {
		ICFSecSecRoleMembH hrec =
			new CFSecBuffSecRoleMembH();
		return( hrec );
	}

	public CFSecBuffSecRoleMembH ensureHRec(ICFSecSecRoleMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecRoleMembH) {
			return( (CFSecBuffSecRoleMembH)hrec );
		}
		else {
			CFSecBuffSecRoleMembH mapped = new CFSecBuffSecRoleMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
