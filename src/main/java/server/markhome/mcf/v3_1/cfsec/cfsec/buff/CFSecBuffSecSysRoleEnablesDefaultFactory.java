
// Description: Java 25 Default Factory implementation for SecSysRoleEnables buffers

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
 *	CFSecBuffSecSysRoleEnablesFactory implementation of ICFSecSecSysRoleEnablesFactory for SecSysRoleEnables
 */
public class CFSecBuffSecSysRoleEnablesDefaultFactory
	implements ICFSecSecSysRoleEnablesFactory
{
	public CFSecBuffSecSysRoleEnablesDefaultFactory() {
	}

    @Override
    public ICFSecSecSysRoleEnablesPKey newPKey() {
        ICFSecSecSysRoleEnablesPKey pkey =
            new CFSecBuffSecSysRoleEnablesPKey();
        return( pkey );
    }

	public CFSecBuffSecSysRoleEnablesPKey ensurePKey(ICFSecSecSysRoleEnablesPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleEnablesPKey) {
			return( (CFSecBuffSecSysRoleEnablesPKey)key );
		}
		else {
			CFSecBuffSecSysRoleEnablesPKey mapped = new CFSecBuffSecSysRoleEnablesPKey();
			mapped.setRequiredContainerSysRole( key.getRequiredSecSysRoleId() );
			mapped.setRequiredParentEnableGroup( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleEnablesHPKey newHPKey() {
		ICFSecSecSysRoleEnablesHPKey hpkey =
			new CFSecBuffSecSysRoleEnablesHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysRoleEnablesHPKey ensureHPKey(ICFSecSecSysRoleEnablesHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysRoleEnablesHPKey) {
			return( (CFSecBuffSecSysRoleEnablesHPKey)key );
		}
		else {
			CFSecBuffSecSysRoleEnablesHPKey mapped = new CFSecBuffSecSysRoleEnablesHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleEnablesBySysRoleIdxKey newBySysRoleIdxKey() {
		ICFSecSecSysRoleEnablesBySysRoleIdxKey key =
			new CFSecBuffSecSysRoleEnablesBySysRoleIdxKey();
		return( key );
	}

	public CFSecBuffSecSysRoleEnablesBySysRoleIdxKey ensureBySysRoleIdxKey(ICFSecSecSysRoleEnablesBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleEnablesBySysRoleIdxKey) {
			return( (CFSecBuffSecSysRoleEnablesBySysRoleIdxKey)key );
		}
		else {
			CFSecBuffSecSysRoleEnablesBySysRoleIdxKey mapped = new CFSecBuffSecSysRoleEnablesBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleEnablesByNameIdxKey newByNameIdxKey() {
		ICFSecSecSysRoleEnablesByNameIdxKey key =
			new CFSecBuffSecSysRoleEnablesByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecSysRoleEnablesByNameIdxKey ensureByNameIdxKey(ICFSecSecSysRoleEnablesByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleEnablesByNameIdxKey) {
			return( (CFSecBuffSecSysRoleEnablesByNameIdxKey)key );
		}
		else {
			CFSecBuffSecSysRoleEnablesByNameIdxKey mapped = new CFSecBuffSecSysRoleEnablesByNameIdxKey();
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleEnables newRec() {
		ICFSecSecSysRoleEnables rec =
			new CFSecBuffSecSysRoleEnables();
		return( rec );
	}

	public CFSecBuffSecSysRoleEnables ensureRec(ICFSecSecSysRoleEnables rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysRoleEnables) {
			return( (CFSecBuffSecSysRoleEnables)rec );
		}
		else {
			CFSecBuffSecSysRoleEnables mapped = new CFSecBuffSecSysRoleEnables();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleEnablesH newHRec() {
		ICFSecSecSysRoleEnablesH hrec =
			new CFSecBuffSecSysRoleEnablesH();
		return( hrec );
	}

	public CFSecBuffSecSysRoleEnablesH ensureHRec(ICFSecSecSysRoleEnablesH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysRoleEnablesH) {
			return( (CFSecBuffSecSysRoleEnablesH)hrec );
		}
		else {
			CFSecBuffSecSysRoleEnablesH mapped = new CFSecBuffSecSysRoleEnablesH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
