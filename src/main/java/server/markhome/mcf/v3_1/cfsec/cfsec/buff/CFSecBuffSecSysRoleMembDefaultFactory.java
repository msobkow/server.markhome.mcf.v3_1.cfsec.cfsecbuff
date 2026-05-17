
// Description: Java 25 Default Factory implementation for SecSysRoleMemb buffers

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
 *	CFSecBuffSecSysRoleMembFactory implementation of ICFSecSecSysRoleMembFactory for SecSysRoleMemb
 */
public class CFSecBuffSecSysRoleMembDefaultFactory
	implements ICFSecSecSysRoleMembFactory
{
	public CFSecBuffSecSysRoleMembDefaultFactory() {
	}

    @Override
    public ICFSecSecSysRoleMembPKey newPKey() {
        ICFSecSecSysRoleMembPKey pkey =
            new CFSecBuffSecSysRoleMembPKey();
        return( pkey );
    }

	public CFSecBuffSecSysRoleMembPKey ensurePKey(ICFSecSecSysRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleMembPKey) {
			return( (CFSecBuffSecSysRoleMembPKey)key );
		}
		else {
			CFSecBuffSecSysRoleMembPKey mapped = new CFSecBuffSecSysRoleMembPKey();
			mapped.setRequiredContainerSysRole( key.getRequiredSecSysRoleId() );
			mapped.setRequiredParentUser( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleMembHPKey newHPKey() {
		ICFSecSecSysRoleMembHPKey hpkey =
			new CFSecBuffSecSysRoleMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysRoleMembHPKey ensureHPKey(ICFSecSecSysRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysRoleMembHPKey) {
			return( (CFSecBuffSecSysRoleMembHPKey)key );
		}
		else {
			CFSecBuffSecSysRoleMembHPKey mapped = new CFSecBuffSecSysRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleMembBySysRoleIdxKey newBySysRoleIdxKey() {
		ICFSecSecSysRoleMembBySysRoleIdxKey key =
			new CFSecBuffSecSysRoleMembBySysRoleIdxKey();
		return( key );
	}

	public CFSecBuffSecSysRoleMembBySysRoleIdxKey ensureBySysRoleIdxKey(ICFSecSecSysRoleMembBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleMembBySysRoleIdxKey) {
			return( (CFSecBuffSecSysRoleMembBySysRoleIdxKey)key );
		}
		else {
			CFSecBuffSecSysRoleMembBySysRoleIdxKey mapped = new CFSecBuffSecSysRoleMembBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleMembByLoginIdxKey newByLoginIdxKey() {
		ICFSecSecSysRoleMembByLoginIdxKey key =
			new CFSecBuffSecSysRoleMembByLoginIdxKey();
		return( key );
	}

	public CFSecBuffSecSysRoleMembByLoginIdxKey ensureByLoginIdxKey(ICFSecSecSysRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleMembByLoginIdxKey) {
			return( (CFSecBuffSecSysRoleMembByLoginIdxKey)key );
		}
		else {
			CFSecBuffSecSysRoleMembByLoginIdxKey mapped = new CFSecBuffSecSysRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleMemb newRec() {
		ICFSecSecSysRoleMemb rec =
			new CFSecBuffSecSysRoleMemb();
		return( rec );
	}

	public CFSecBuffSecSysRoleMemb ensureRec(ICFSecSecSysRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysRoleMemb) {
			return( (CFSecBuffSecSysRoleMemb)rec );
		}
		else {
			CFSecBuffSecSysRoleMemb mapped = new CFSecBuffSecSysRoleMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleMembH newHRec() {
		ICFSecSecSysRoleMembH hrec =
			new CFSecBuffSecSysRoleMembH();
		return( hrec );
	}

	public CFSecBuffSecSysRoleMembH ensureHRec(ICFSecSecSysRoleMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysRoleMembH) {
			return( (CFSecBuffSecSysRoleMembH)hrec );
		}
		else {
			CFSecBuffSecSysRoleMembH mapped = new CFSecBuffSecSysRoleMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
