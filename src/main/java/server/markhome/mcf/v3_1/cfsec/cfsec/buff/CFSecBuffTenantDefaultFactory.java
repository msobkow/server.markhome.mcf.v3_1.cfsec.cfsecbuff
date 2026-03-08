
// Description: Java 25 Default Factory implementation for Tenant buffers

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
 *	CFSecBuffTenantFactory implementation of ICFSecTenantFactory for Tenant
 */
public class CFSecBuffTenantDefaultFactory
	implements ICFSecTenantFactory
{
	public CFSecBuffTenantDefaultFactory() {
	}

	@Override
	public ICFSecTenantHPKey newHPKey() {
		ICFSecTenantHPKey hpkey =
			new CFSecBuffTenantHPKey();
		return( hpkey );
	}

	public CFSecBuffTenantHPKey ensureHPKey(ICFSecTenantHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffTenantHPKey) {
			return( (CFSecBuffTenantHPKey)key );
		}
		else {
			CFSecBuffTenantHPKey mapped = new CFSecBuffTenantHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantByClusterIdxKey newByClusterIdxKey() {
		ICFSecTenantByClusterIdxKey key =
			new CFSecBuffTenantByClusterIdxKey();
		return( key );
	}

	public CFSecBuffTenantByClusterIdxKey ensureByClusterIdxKey(ICFSecTenantByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTenantByClusterIdxKey) {
			return( (CFSecBuffTenantByClusterIdxKey)key );
		}
		else {
			CFSecBuffTenantByClusterIdxKey mapped = new CFSecBuffTenantByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantByUNameIdxKey newByUNameIdxKey() {
		ICFSecTenantByUNameIdxKey key =
			new CFSecBuffTenantByUNameIdxKey();
		return( key );
	}

	public CFSecBuffTenantByUNameIdxKey ensureByUNameIdxKey(ICFSecTenantByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffTenantByUNameIdxKey) {
			return( (CFSecBuffTenantByUNameIdxKey)key );
		}
		else {
			CFSecBuffTenantByUNameIdxKey mapped = new CFSecBuffTenantByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredTenantName( key.getRequiredTenantName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecTenant newRec() {
		ICFSecTenant rec =
			new CFSecBuffTenant();
		return( rec );
	}

	public CFSecBuffTenant ensureRec(ICFSecTenant rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffTenant) {
			return( (CFSecBuffTenant)rec );
		}
		else {
			CFSecBuffTenant mapped = new CFSecBuffTenant();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecTenantH newHRec() {
		ICFSecTenantH hrec =
			new CFSecBuffTenantH();
		return( hrec );
	}

	public CFSecBuffTenantH ensureHRec(ICFSecTenantH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffTenantH) {
			return( (CFSecBuffTenantH)hrec );
		}
		else {
			CFSecBuffTenantH mapped = new CFSecBuffTenantH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
