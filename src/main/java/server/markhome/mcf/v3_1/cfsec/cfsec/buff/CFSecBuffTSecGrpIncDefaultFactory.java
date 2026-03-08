
// Description: Java 25 Default Factory implementation for TSecGrpInc buffers

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
 *	CFSecBuffTSecGrpIncFactory implementation of ICFSecTSecGrpIncFactory for TSecGrpInc
 */
public class CFSecBuffTSecGrpIncDefaultFactory
	implements ICFSecTSecGrpIncFactory
{
	public CFSecBuffTSecGrpIncDefaultFactory() {
	}

	@Override
	public ICFSecTSecGrpIncHPKey newHPKey() {
		ICFSecTSecGrpIncHPKey hpkey =
			new CFSecBuffTSecGrpIncHPKey();
		return( hpkey );
	}

	public CFSecBuffTSecGrpIncHPKey ensureHPKey(ICFSecTSecGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffTSecGrpIncHPKey) {
			return( (CFSecBuffTSecGrpIncHPKey)key );
		}
		else {
			CFSecBuffTSecGrpIncHPKey mapped = new CFSecBuffTSecGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredTSecGrpIncId( key.getRequiredTSecGrpIncId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpIncByTenantIdxKey newByTenantIdxKey() {
		ICFSecTSecGrpIncByTenantIdxKey key =
			new CFSecBuffTSecGrpIncByTenantIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpIncByTenantIdxKey ensureByTenantIdxKey(ICFSecTSecGrpIncByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpIncByTenantIdxKey) {
			return( (CFSecBuffTSecGrpIncByTenantIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpIncByTenantIdxKey mapped = new CFSecBuffTSecGrpIncByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpIncByGroupIdxKey newByGroupIdxKey() {
		ICFSecTSecGrpIncByGroupIdxKey key =
			new CFSecBuffTSecGrpIncByGroupIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpIncByGroupIdxKey ensureByGroupIdxKey(ICFSecTSecGrpIncByGroupIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpIncByGroupIdxKey) {
			return( (CFSecBuffTSecGrpIncByGroupIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpIncByGroupIdxKey mapped = new CFSecBuffTSecGrpIncByGroupIdxKey();
			mapped.setRequiredTSecGroupId( key.getRequiredTSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpIncByIncludeIdxKey newByIncludeIdxKey() {
		ICFSecTSecGrpIncByIncludeIdxKey key =
			new CFSecBuffTSecGrpIncByIncludeIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpIncByIncludeIdxKey ensureByIncludeIdxKey(ICFSecTSecGrpIncByIncludeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpIncByIncludeIdxKey) {
			return( (CFSecBuffTSecGrpIncByIncludeIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpIncByIncludeIdxKey mapped = new CFSecBuffTSecGrpIncByIncludeIdxKey();
			mapped.setRequiredIncludeGroupId( key.getRequiredIncludeGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpIncByUIncludeIdxKey newByUIncludeIdxKey() {
		ICFSecTSecGrpIncByUIncludeIdxKey key =
			new CFSecBuffTSecGrpIncByUIncludeIdxKey();
		return( key );
	}

	public CFSecBuffTSecGrpIncByUIncludeIdxKey ensureByUIncludeIdxKey(ICFSecTSecGrpIncByUIncludeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTSecGrpIncByUIncludeIdxKey) {
			return( (CFSecBuffTSecGrpIncByUIncludeIdxKey)key );
		}
		else {
			CFSecBuffTSecGrpIncByUIncludeIdxKey mapped = new CFSecBuffTSecGrpIncByUIncludeIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredTSecGroupId( key.getRequiredTSecGroupId() );
			mapped.setRequiredIncludeGroupId( key.getRequiredIncludeGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpInc newRec() {
		ICFSecTSecGrpInc rec =
			new CFSecBuffTSecGrpInc();
		return( rec );
	}

	public CFSecBuffTSecGrpInc ensureRec(ICFSecTSecGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffTSecGrpInc) {
			return( (CFSecBuffTSecGrpInc)rec );
		}
		else {
			CFSecBuffTSecGrpInc mapped = new CFSecBuffTSecGrpInc();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecTSecGrpIncH newHRec() {
		ICFSecTSecGrpIncH hrec =
			new CFSecBuffTSecGrpIncH();
		return( hrec );
	}

	public CFSecBuffTSecGrpIncH ensureHRec(ICFSecTSecGrpIncH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffTSecGrpIncH) {
			return( (CFSecBuffTSecGrpIncH)hrec );
		}
		else {
			CFSecBuffTSecGrpIncH mapped = new CFSecBuffTSecGrpIncH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
