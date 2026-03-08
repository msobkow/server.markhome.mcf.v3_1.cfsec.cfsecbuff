
// Description: Java 25 Default Factory implementation for TSecGrpMemb buffers

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
 *	CFSecBuffTSecGrpMembFactory implementation of ICFSecTSecGrpMembFactory for TSecGrpMemb
 */
public class CFSecBuffTSecGrpMembDefaultFactory
	implements ICFSecTSecGrpMembFactory
{
	public CFSecBuffTSecGrpMembDefaultFactory() {
	}

	@Override
	public ICFSecTSecGrpMembHPKey newHPKey() {
		ICFSecTSecGrpMembHPKey hpkey =
			new CFSecBuffTSecGrpMembHPKey();
		return( hpkey );
	}

	public CFSecBuffTSecGrpMembHPKey ensureHPKey(ICFSecTSecGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffTSecGrpMembHPKey) {
			return( (CFSecBuffTSecGrpMembHPKey)key );
		}
		else {
			CFSecBuffTSecGrpMembHPKey mapped = new CFSecBuffTSecGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredTSecGrpMembId( key.getRequiredTSecGrpMembId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMembByTenantIdxKey newByTenantIdxKey() {
		ICFSecTSecGrpMembByTenantIdxKey key =
			new CFSecBuffTSecGrpMembByTenantIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpMembByTenantIdxKey ensureByTenantIdxKey(ICFSecTSecGrpMembByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpMembByTenantIdxKey) {
			return( (CFSecBuffTSecGrpMembByTenantIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpMembByTenantIdxKey mapped = new CFSecBuffTSecGrpMembByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMembByGroupIdxKey newByGroupIdxKey() {
		ICFSecTSecGrpMembByGroupIdxKey key =
			new CFSecBuffTSecGrpMembByGroupIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpMembByGroupIdxKey ensureByGroupIdxKey(ICFSecTSecGrpMembByGroupIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpMembByGroupIdxKey) {
			return( (CFSecBuffTSecGrpMembByGroupIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpMembByGroupIdxKey mapped = new CFSecBuffTSecGrpMembByGroupIdxKey();
			mapped.setRequiredTSecGroupId( key.getRequiredTSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMembByUserIdxKey newByUserIdxKey() {
		ICFSecTSecGrpMembByUserIdxKey key =
			new CFSecBuffTSecGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpMembByUserIdxKey ensureByUserIdxKey(ICFSecTSecGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpMembByUserIdxKey) {
			return( (CFSecBuffTSecGrpMembByUserIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpMembByUserIdxKey mapped = new CFSecBuffTSecGrpMembByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMembByUUserIdxKey newByUUserIdxKey() {
		ICFSecTSecGrpMembByUUserIdxKey key =
			new CFSecBuffTSecGrpMembByUUserIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpMembByUUserIdxKey ensureByUUserIdxKey(ICFSecTSecGrpMembByUUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpMembByUUserIdxKey) {
			return( (CFSecBuffTSecGrpMembByUUserIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpMembByUUserIdxKey mapped = new CFSecBuffTSecGrpMembByUUserIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredTSecGroupId( key.getRequiredTSecGroupId() );
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMemb newRec() {
		ICFSecTSecGrpMemb rec =
			new CFSecBuffTSecGrpMemb();
		return( rec );
	}

	public CFSecBuffTSecGrpMemb ensureRec(ICFSecTSecGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffTSecGrpMemb) {
			return( (CFSecBuffTSecGrpMemb)rec );
		}
		else {
			CFSecBuffTSecGrpMemb mapped = new CFSecBuffTSecGrpMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpMembH newHRec() {
		ICFSecTSecGrpMembH hrec =
			new CFSecBuffTSecGrpMembH();
		return( hrec );
	}

	public CFSecBuffTSecGrpMembH ensureHRec(ICFSecTSecGrpMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffTSecGrpMembH) {
			return( (CFSecBuffTSecGrpMembH)hrec );
		}
		else {
			CFSecBuffTSecGrpMembH mapped = new CFSecBuffTSecGrpMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
