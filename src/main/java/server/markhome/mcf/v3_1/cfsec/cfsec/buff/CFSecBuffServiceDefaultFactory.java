
// Description: Java 25 Default Factory implementation for Service buffers

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
 *	CFSecBuffServiceFactory implementation of ICFSecServiceFactory for Service
 */
public class CFSecBuffServiceDefaultFactory
	implements ICFSecServiceFactory
{
	public CFSecBuffServiceDefaultFactory() {
	}

	@Override
	public ICFSecServiceHPKey newHPKey() {
		ICFSecServiceHPKey hpkey =
			new CFSecBuffServiceHPKey();
		return( hpkey );
	}

	public CFSecBuffServiceHPKey ensureHPKey(ICFSecServiceHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffServiceHPKey) {
			return( (CFSecBuffServiceHPKey)key );
		}
		else {
			CFSecBuffServiceHPKey mapped = new CFSecBuffServiceHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredServiceId( key.getRequiredServiceId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceByClusterIdxKey newByClusterIdxKey() {
		ICFSecServiceByClusterIdxKey key =
			new CFSecBuffServiceByClusterIdxKey();
		return( key );
	}

	public CFSecBuffServiceByClusterIdxKey ensureByClusterIdxKey(ICFSecServiceByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceByClusterIdxKey) {
			return( (CFSecBuffServiceByClusterIdxKey)key );
		}
		else {
			CFSecBuffServiceByClusterIdxKey mapped = new CFSecBuffServiceByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceByHostIdxKey newByHostIdxKey() {
		ICFSecServiceByHostIdxKey key =
			new CFSecBuffServiceByHostIdxKey();
		return( key );
	}

	public CFSecBuffServiceByHostIdxKey ensureByHostIdxKey(ICFSecServiceByHostIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceByHostIdxKey) {
			return( (CFSecBuffServiceByHostIdxKey)key );
		}
		else {
			CFSecBuffServiceByHostIdxKey mapped = new CFSecBuffServiceByHostIdxKey();
			mapped.setRequiredHostNodeId( key.getRequiredHostNodeId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceByTypeIdxKey newByTypeIdxKey() {
		ICFSecServiceByTypeIdxKey key =
			new CFSecBuffServiceByTypeIdxKey();
		return( key );
	}

	public CFSecBuffServiceByTypeIdxKey ensureByTypeIdxKey(ICFSecServiceByTypeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceByTypeIdxKey) {
			return( (CFSecBuffServiceByTypeIdxKey)key );
		}
		else {
			CFSecBuffServiceByTypeIdxKey mapped = new CFSecBuffServiceByTypeIdxKey();
			mapped.setRequiredServiceTypeId( key.getRequiredServiceTypeId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceByUTypeIdxKey newByUTypeIdxKey() {
		ICFSecServiceByUTypeIdxKey key =
			new CFSecBuffServiceByUTypeIdxKey();
		return( key );
	}

	public CFSecBuffServiceByUTypeIdxKey ensureByUTypeIdxKey(ICFSecServiceByUTypeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceByUTypeIdxKey) {
			return( (CFSecBuffServiceByUTypeIdxKey)key );
		}
		else {
			CFSecBuffServiceByUTypeIdxKey mapped = new CFSecBuffServiceByUTypeIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredHostNodeId( key.getRequiredHostNodeId() );
			mapped.setRequiredServiceTypeId( key.getRequiredServiceTypeId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceByUHostPortIdxKey newByUHostPortIdxKey() {
		ICFSecServiceByUHostPortIdxKey key =
			new CFSecBuffServiceByUHostPortIdxKey();
		return( key );
	}

	public CFSecBuffServiceByUHostPortIdxKey ensureByUHostPortIdxKey(ICFSecServiceByUHostPortIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceByUHostPortIdxKey) {
			return( (CFSecBuffServiceByUHostPortIdxKey)key );
		}
		else {
			CFSecBuffServiceByUHostPortIdxKey mapped = new CFSecBuffServiceByUHostPortIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredHostNodeId( key.getRequiredHostNodeId() );
			mapped.setRequiredHostPort( key.getRequiredHostPort() );
			return( mapped );
		}
	}

	@Override
	public ICFSecService newRec() {
		ICFSecService rec =
			new CFSecBuffService();
		return( rec );
	}

	public CFSecBuffService ensureRec(ICFSecService rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffService) {
			return( (CFSecBuffService)rec );
		}
		else {
			CFSecBuffService mapped = new CFSecBuffService();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceH newHRec() {
		ICFSecServiceH hrec =
			new CFSecBuffServiceH();
		return( hrec );
	}

	public CFSecBuffServiceH ensureHRec(ICFSecServiceH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffServiceH) {
			return( (CFSecBuffServiceH)hrec );
		}
		else {
			CFSecBuffServiceH mapped = new CFSecBuffServiceH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
