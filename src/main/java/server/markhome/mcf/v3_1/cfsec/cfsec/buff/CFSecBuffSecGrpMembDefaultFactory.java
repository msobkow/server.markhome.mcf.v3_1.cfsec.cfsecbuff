
// Description: Java 25 Default Factory implementation for SecGrpMemb buffers

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
 *	CFSecBuffSecGrpMembFactory implementation of ICFSecSecGrpMembFactory for SecGrpMemb
 */
public class CFSecBuffSecGrpMembDefaultFactory
	implements ICFSecSecGrpMembFactory
{
	public CFSecBuffSecGrpMembDefaultFactory() {
	}

	@Override
	public ICFSecSecGrpMembHPKey newHPKey() {
		ICFSecSecGrpMembHPKey hpkey =
			new CFSecBuffSecGrpMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecGrpMembHPKey ensureHPKey(ICFSecSecGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecGrpMembHPKey) {
			return( (CFSecBuffSecGrpMembHPKey)key );
		}
		else {
			CFSecBuffSecGrpMembHPKey mapped = new CFSecBuffSecGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecGrpMembId( key.getRequiredSecGrpMembId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMembByClusterIdxKey newByClusterIdxKey() {
		ICFSecSecGrpMembByClusterIdxKey key =
			new CFSecBuffSecGrpMembByClusterIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpMembByClusterIdxKey ensureByClusterIdxKey(ICFSecSecGrpMembByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpMembByClusterIdxKey) {
			return( (CFSecBuffSecGrpMembByClusterIdxKey)key );
		}
		else {
			CFSecBuffSecGrpMembByClusterIdxKey mapped = new CFSecBuffSecGrpMembByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMembByGroupIdxKey newByGroupIdxKey() {
		ICFSecSecGrpMembByGroupIdxKey key =
			new CFSecBuffSecGrpMembByGroupIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpMembByGroupIdxKey ensureByGroupIdxKey(ICFSecSecGrpMembByGroupIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpMembByGroupIdxKey) {
			return( (CFSecBuffSecGrpMembByGroupIdxKey)key );
		}
		else {
			CFSecBuffSecGrpMembByGroupIdxKey mapped = new CFSecBuffSecGrpMembByGroupIdxKey();
			mapped.setRequiredSecGroupId( key.getRequiredSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMembByUserIdxKey newByUserIdxKey() {
		ICFSecSecGrpMembByUserIdxKey key =
			new CFSecBuffSecGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpMembByUserIdxKey ensureByUserIdxKey(ICFSecSecGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpMembByUserIdxKey) {
			return( (CFSecBuffSecGrpMembByUserIdxKey)key );
		}
		else {
			CFSecBuffSecGrpMembByUserIdxKey mapped = new CFSecBuffSecGrpMembByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMembByUUserIdxKey newByUUserIdxKey() {
		ICFSecSecGrpMembByUUserIdxKey key =
			new CFSecBuffSecGrpMembByUUserIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpMembByUUserIdxKey ensureByUUserIdxKey(ICFSecSecGrpMembByUUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpMembByUUserIdxKey) {
			return( (CFSecBuffSecGrpMembByUUserIdxKey)key );
		}
		else {
			CFSecBuffSecGrpMembByUUserIdxKey mapped = new CFSecBuffSecGrpMembByUUserIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredSecGroupId( key.getRequiredSecGroupId() );
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMemb newRec() {
		ICFSecSecGrpMemb rec =
			new CFSecBuffSecGrpMemb();
		return( rec );
	}

	public CFSecBuffSecGrpMemb ensureRec(ICFSecSecGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecGrpMemb) {
			return( (CFSecBuffSecGrpMemb)rec );
		}
		else {
			CFSecBuffSecGrpMemb mapped = new CFSecBuffSecGrpMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpMembH newHRec() {
		ICFSecSecGrpMembH hrec =
			new CFSecBuffSecGrpMembH();
		return( hrec );
	}

	public CFSecBuffSecGrpMembH ensureHRec(ICFSecSecGrpMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecGrpMembH) {
			return( (CFSecBuffSecGrpMembH)hrec );
		}
		else {
			CFSecBuffSecGrpMembH mapped = new CFSecBuffSecGrpMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
