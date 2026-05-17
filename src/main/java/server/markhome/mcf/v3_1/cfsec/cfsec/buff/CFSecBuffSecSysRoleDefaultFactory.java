
// Description: Java 25 Default Factory implementation for SecSysRole buffers

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
 *	CFSecBuffSecSysRoleFactory implementation of ICFSecSecSysRoleFactory for SecSysRole
 */
public class CFSecBuffSecSysRoleDefaultFactory
	implements ICFSecSecSysRoleFactory
{
	public CFSecBuffSecSysRoleDefaultFactory() {
	}

	@Override
	public ICFSecSecSysRoleHPKey newHPKey() {
		ICFSecSecSysRoleHPKey hpkey =
			new CFSecBuffSecSysRoleHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysRoleHPKey ensureHPKey(ICFSecSecSysRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysRoleHPKey) {
			return( (CFSecBuffSecSysRoleHPKey)key );
		}
		else {
			CFSecBuffSecSysRoleHPKey mapped = new CFSecBuffSecSysRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecSysRoleByUNameIdxKey key =
			new CFSecBuffSecSysRoleByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecSysRoleByUNameIdxKey ensureByUNameIdxKey(ICFSecSecSysRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysRoleByUNameIdxKey) {
			return( (CFSecBuffSecSysRoleByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecSysRoleByUNameIdxKey mapped = new CFSecBuffSecSysRoleByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRole newRec() {
		ICFSecSecSysRole rec =
			new CFSecBuffSecSysRole();
		return( rec );
	}

	public CFSecBuffSecSysRole ensureRec(ICFSecSecSysRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysRole) {
			return( (CFSecBuffSecSysRole)rec );
		}
		else {
			CFSecBuffSecSysRole mapped = new CFSecBuffSecSysRole();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysRoleH newHRec() {
		ICFSecSecSysRoleH hrec =
			new CFSecBuffSecSysRoleH();
		return( hrec );
	}

	public CFSecBuffSecSysRoleH ensureHRec(ICFSecSecSysRoleH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysRoleH) {
			return( (CFSecBuffSecSysRoleH)hrec );
		}
		else {
			CFSecBuffSecSysRoleH mapped = new CFSecBuffSecSysRoleH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
