
// Description: Java 25 Default Factory implementation for SecRole buffers

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
 *	CFSecBuffSecRoleFactory implementation of ICFSecSecRoleFactory for SecRole
 */
public class CFSecBuffSecRoleDefaultFactory
	implements ICFSecSecRoleFactory
{
	public CFSecBuffSecRoleDefaultFactory() {
	}

	@Override
	public ICFSecSecRoleHPKey newHPKey() {
		ICFSecSecRoleHPKey hpkey =
			new CFSecBuffSecRoleHPKey();
		return( hpkey );
	}

	public CFSecBuffSecRoleHPKey ensureHPKey(ICFSecSecRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecRoleHPKey) {
			return( (CFSecBuffSecRoleHPKey)key );
		}
		else {
			CFSecBuffSecRoleHPKey mapped = new CFSecBuffSecRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecRoleId( key.getRequiredSecRoleId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecRoleByUNameIdxKey key =
			new CFSecBuffSecRoleByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecRoleByUNameIdxKey ensureByUNameIdxKey(ICFSecSecRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecRoleByUNameIdxKey) {
			return( (CFSecBuffSecRoleByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecRoleByUNameIdxKey mapped = new CFSecBuffSecRoleByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRole newRec() {
		ICFSecSecRole rec =
			new CFSecBuffSecRole();
		return( rec );
	}

	public CFSecBuffSecRole ensureRec(ICFSecSecRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecRole) {
			return( (CFSecBuffSecRole)rec );
		}
		else {
			CFSecBuffSecRole mapped = new CFSecBuffSecRole();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecRoleH newHRec() {
		ICFSecSecRoleH hrec =
			new CFSecBuffSecRoleH();
		return( hrec );
	}

	public CFSecBuffSecRoleH ensureHRec(ICFSecSecRoleH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecRoleH) {
			return( (CFSecBuffSecRoleH)hrec );
		}
		else {
			CFSecBuffSecRoleH mapped = new CFSecBuffSecRoleH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
