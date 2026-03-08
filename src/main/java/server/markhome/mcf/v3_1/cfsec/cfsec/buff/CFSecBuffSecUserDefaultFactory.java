
// Description: Java 25 Default Factory implementation for SecUser buffers

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
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
 *	CFSecBuffSecUserFactory implementation of ICFSecSecUserFactory for SecUser
 */
public class CFSecBuffSecUserDefaultFactory
	implements ICFSecSecUserFactory
{
	public CFSecBuffSecUserDefaultFactory() {
	}

	@Override
	public ICFSecSecUserHPKey newHPKey() {
		ICFSecSecUserHPKey hpkey =
			new CFSecBuffSecUserHPKey();
		return( hpkey );
	}

	public CFSecBuffSecUserHPKey ensureHPKey(ICFSecSecUserHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecUserHPKey) {
			return( (CFSecBuffSecUserHPKey)key );
		}
		else {
			CFSecBuffSecUserHPKey mapped = new CFSecBuffSecUserHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByULoginIdxKey newByULoginIdxKey() {
		ICFSecSecUserByULoginIdxKey key =
			new CFSecBuffSecUserByULoginIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByULoginIdxKey ensureByULoginIdxKey(ICFSecSecUserByULoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByULoginIdxKey) {
			return( (CFSecBuffSecUserByULoginIdxKey)key );
		}
		else {
			CFSecBuffSecUserByULoginIdxKey mapped = new CFSecBuffSecUserByULoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByEMConfIdxKey newByEMConfIdxKey() {
		ICFSecSecUserByEMConfIdxKey key =
			new CFSecBuffSecUserByEMConfIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByEMConfIdxKey ensureByEMConfIdxKey(ICFSecSecUserByEMConfIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByEMConfIdxKey) {
			return( (CFSecBuffSecUserByEMConfIdxKey)key );
		}
		else {
			CFSecBuffSecUserByEMConfIdxKey mapped = new CFSecBuffSecUserByEMConfIdxKey();
			mapped.setOptionalEMailConfirmUuid6( key.getOptionalEMailConfirmUuid6() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByPwdResetIdxKey newByPwdResetIdxKey() {
		ICFSecSecUserByPwdResetIdxKey key =
			new CFSecBuffSecUserByPwdResetIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByPwdResetIdxKey ensureByPwdResetIdxKey(ICFSecSecUserByPwdResetIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByPwdResetIdxKey) {
			return( (CFSecBuffSecUserByPwdResetIdxKey)key );
		}
		else {
			CFSecBuffSecUserByPwdResetIdxKey mapped = new CFSecBuffSecUserByPwdResetIdxKey();
			mapped.setOptionalPasswordResetUuid6( key.getOptionalPasswordResetUuid6() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByDefDevIdxKey newByDefDevIdxKey() {
		ICFSecSecUserByDefDevIdxKey key =
			new CFSecBuffSecUserByDefDevIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByDefDevIdxKey ensureByDefDevIdxKey(ICFSecSecUserByDefDevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByDefDevIdxKey) {
			return( (CFSecBuffSecUserByDefDevIdxKey)key );
		}
		else {
			CFSecBuffSecUserByDefDevIdxKey mapped = new CFSecBuffSecUserByDefDevIdxKey();
			mapped.setOptionalDfltDevUserId( key.getOptionalDfltDevUserId() );
			mapped.setOptionalDfltDevName( key.getOptionalDfltDevName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUser newRec() {
		ICFSecSecUser rec =
			new CFSecBuffSecUser();
		return( rec );
	}

	public CFSecBuffSecUser ensureRec(ICFSecSecUser rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUser) {
			return( (CFSecBuffSecUser)rec );
		}
		else {
			CFSecBuffSecUser mapped = new CFSecBuffSecUser();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserH newHRec() {
		ICFSecSecUserH hrec =
			new CFSecBuffSecUserH();
		return( hrec );
	}

	public CFSecBuffSecUserH ensureHRec(ICFSecSecUserH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecUserH) {
			return( (CFSecBuffSecUserH)hrec );
		}
		else {
			CFSecBuffSecUserH mapped = new CFSecBuffSecUserH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
