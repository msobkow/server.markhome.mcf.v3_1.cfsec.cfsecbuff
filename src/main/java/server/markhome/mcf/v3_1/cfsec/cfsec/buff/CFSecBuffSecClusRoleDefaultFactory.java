
// Description: Java 25 Default Factory implementation for SecClusRole buffers

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
 *	CFSecBuffSecClusRoleFactory implementation of ICFSecSecClusRoleFactory for SecClusRole
 */
public class CFSecBuffSecClusRoleDefaultFactory
	implements ICFSecSecClusRoleFactory
{
	public CFSecBuffSecClusRoleDefaultFactory() {
	}

	@Override
	public ICFSecSecClusRoleHPKey newHPKey() {
		ICFSecSecClusRoleHPKey hpkey =
			new CFSecBuffSecClusRoleHPKey();
		return( hpkey );
	}

	public CFSecBuffSecClusRoleHPKey ensureHPKey(ICFSecSecClusRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecClusRoleHPKey) {
			return( (CFSecBuffSecClusRoleHPKey)key );
		}
		else {
			CFSecBuffSecClusRoleHPKey mapped = new CFSecBuffSecClusRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusRoleByClusterIdxKey newByClusterIdxKey() {
		ICFSecSecClusRoleByClusterIdxKey key =
			new CFSecBuffSecClusRoleByClusterIdxKey();
		return( key );
	}

	public CFSecBuffSecClusRoleByClusterIdxKey ensureByClusterIdxKey(ICFSecSecClusRoleByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusRoleByClusterIdxKey) {
			return( (CFSecBuffSecClusRoleByClusterIdxKey)key );
		}
		else {
			CFSecBuffSecClusRoleByClusterIdxKey mapped = new CFSecBuffSecClusRoleByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusRoleByNameIdxKey newByNameIdxKey() {
		ICFSecSecClusRoleByNameIdxKey key =
			new CFSecBuffSecClusRoleByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecClusRoleByNameIdxKey ensureByNameIdxKey(ICFSecSecClusRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusRoleByNameIdxKey) {
			return( (CFSecBuffSecClusRoleByNameIdxKey)key );
		}
		else {
			CFSecBuffSecClusRoleByNameIdxKey mapped = new CFSecBuffSecClusRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusRoleByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecClusRoleByUNameIdxKey key =
			new CFSecBuffSecClusRoleByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecClusRoleByUNameIdxKey ensureByUNameIdxKey(ICFSecSecClusRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusRoleByUNameIdxKey) {
			return( (CFSecBuffSecClusRoleByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecClusRoleByUNameIdxKey mapped = new CFSecBuffSecClusRoleByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusRole newRec() {
		ICFSecSecClusRole rec =
			new CFSecBuffSecClusRole();
		return( rec );
	}

	public CFSecBuffSecClusRole ensureRec(ICFSecSecClusRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecClusRole) {
			return( (CFSecBuffSecClusRole)rec );
		}
		else {
			CFSecBuffSecClusRole mapped = new CFSecBuffSecClusRole();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusRoleH newHRec() {
		ICFSecSecClusRoleH hrec =
			new CFSecBuffSecClusRoleH();
		return( hrec );
	}

	public CFSecBuffSecClusRoleH ensureHRec(ICFSecSecClusRoleH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecClusRoleH) {
			return( (CFSecBuffSecClusRoleH)hrec );
		}
		else {
			CFSecBuffSecClusRoleH mapped = new CFSecBuffSecClusRoleH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
