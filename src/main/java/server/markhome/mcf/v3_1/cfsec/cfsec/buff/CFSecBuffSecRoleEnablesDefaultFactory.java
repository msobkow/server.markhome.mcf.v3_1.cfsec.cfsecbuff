
// Description: Java 25 Default Factory implementation for SecRoleEnables buffers

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
 *	CFSecBuffSecRoleEnablesFactory implementation of ICFSecSecRoleEnablesFactory for SecRoleEnables
 */
public class CFSecBuffSecRoleEnablesDefaultFactory
	implements ICFSecSecRoleEnablesFactory
{
	public CFSecBuffSecRoleEnablesDefaultFactory() {
	}

    @Override
    public ICFSecSecRoleEnablesPKey newPKey() {
        ICFSecSecRoleEnablesPKey pkey =
            new CFSecBuffSecRoleEnablesPKey();
        return( pkey );
    }

	public CFSecBuffSecRoleEnablesPKey ensurePKey(ICFSecSecRoleEnablesPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleEnablesPKey) {
			return( (CFSecBuffSecRoleEnablesPKey)key );
		}
		else {
			CFSecBuffSecRoleEnablesPKey mapped = new CFSecBuffSecRoleEnablesPKey();
			mapped.setRequiredContainerRole( key.getRequiredSecRoleId() );
			mapped.setRequiredParentEnableGroup( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleEnablesHPKey newHPKey() {
		ICFSecSecRoleEnablesHPKey hpkey =
			new CFSecBuffSecRoleEnablesHPKey();
		return( hpkey );
	}

	public CFSecBuffSecRoleEnablesHPKey ensureHPKey(ICFSecSecRoleEnablesHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecRoleEnablesHPKey) {
			return( (CFSecBuffSecRoleEnablesHPKey)key );
		}
		else {
			CFSecBuffSecRoleEnablesHPKey mapped = new CFSecBuffSecRoleEnablesHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecRoleId( key.getRequiredSecRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleEnablesByRoleIdxKey newByRoleIdxKey() {
		ICFSecSecRoleEnablesByRoleIdxKey key =
			new CFSecBuffSecRoleEnablesByRoleIdxKey();
		return( key );
	}

	public CFSecBuffSecRoleEnablesByRoleIdxKey ensureByRoleIdxKey(ICFSecSecRoleEnablesByRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleEnablesByRoleIdxKey) {
			return( (CFSecBuffSecRoleEnablesByRoleIdxKey)key );
		}
		else {
			CFSecBuffSecRoleEnablesByRoleIdxKey mapped = new CFSecBuffSecRoleEnablesByRoleIdxKey();
			mapped.setRequiredSecRoleId( key.getRequiredSecRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleEnablesByNameIdxKey newByNameIdxKey() {
		ICFSecSecRoleEnablesByNameIdxKey key =
			new CFSecBuffSecRoleEnablesByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecRoleEnablesByNameIdxKey ensureByNameIdxKey(ICFSecSecRoleEnablesByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleEnablesByNameIdxKey) {
			return( (CFSecBuffSecRoleEnablesByNameIdxKey)key );
		}
		else {
			CFSecBuffSecRoleEnablesByNameIdxKey mapped = new CFSecBuffSecRoleEnablesByNameIdxKey();
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleEnables newRec() {
		ICFSecSecRoleEnables rec =
			new CFSecBuffSecRoleEnables();
		return( rec );
	}

	public CFSecBuffSecRoleEnables ensureRec(ICFSecSecRoleEnables rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecRoleEnables) {
			return( (CFSecBuffSecRoleEnables)rec );
		}
		else {
			CFSecBuffSecRoleEnables mapped = new CFSecBuffSecRoleEnables();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleEnablesH newHRec() {
		ICFSecSecRoleEnablesH hrec =
			new CFSecBuffSecRoleEnablesH();
		return( hrec );
	}

	public CFSecBuffSecRoleEnablesH ensureHRec(ICFSecSecRoleEnablesH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecRoleEnablesH) {
			return( (CFSecBuffSecRoleEnablesH)hrec );
		}
		else {
			CFSecBuffSecRoleEnablesH mapped = new CFSecBuffSecRoleEnablesH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
