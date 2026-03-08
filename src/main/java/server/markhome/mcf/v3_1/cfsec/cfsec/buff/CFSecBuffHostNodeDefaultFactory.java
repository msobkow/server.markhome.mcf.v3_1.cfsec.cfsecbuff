
// Description: Java 25 Default Factory implementation for HostNode buffers

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
 *	CFSecBuffHostNodeFactory implementation of ICFSecHostNodeFactory for HostNode
 */
public class CFSecBuffHostNodeDefaultFactory
	implements ICFSecHostNodeFactory
{
	public CFSecBuffHostNodeDefaultFactory() {
	}

	@Override
	public ICFSecHostNodeHPKey newHPKey() {
		ICFSecHostNodeHPKey hpkey =
			new CFSecBuffHostNodeHPKey();
		return( hpkey );
	}

	public CFSecBuffHostNodeHPKey ensureHPKey(ICFSecHostNodeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffHostNodeHPKey) {
			return( (CFSecBuffHostNodeHPKey)key );
		}
		else {
			CFSecBuffHostNodeHPKey mapped = new CFSecBuffHostNodeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredHostNodeId( key.getRequiredHostNodeId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecHostNodeByClusterIdxKey newByClusterIdxKey() {
		ICFSecHostNodeByClusterIdxKey key =
			new CFSecBuffHostNodeByClusterIdxKey();
		return( key );
	}

	public CFSecBuffHostNodeByClusterIdxKey ensureByClusterIdxKey(ICFSecHostNodeByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffHostNodeByClusterIdxKey) {
			return( (CFSecBuffHostNodeByClusterIdxKey)key );
		}
		else {
			CFSecBuffHostNodeByClusterIdxKey mapped = new CFSecBuffHostNodeByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecHostNodeByUDescrIdxKey newByUDescrIdxKey() {
		ICFSecHostNodeByUDescrIdxKey key =
			new CFSecBuffHostNodeByUDescrIdxKey();
		return( key );
	}

	public CFSecBuffHostNodeByUDescrIdxKey ensureByUDescrIdxKey(ICFSecHostNodeByUDescrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffHostNodeByUDescrIdxKey) {
			return( (CFSecBuffHostNodeByUDescrIdxKey)key );
		}
		else {
			CFSecBuffHostNodeByUDescrIdxKey mapped = new CFSecBuffHostNodeByUDescrIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredDescription( key.getRequiredDescription() );
			return( mapped );
		}
	}

	@Override
	public ICFSecHostNodeByHostNameIdxKey newByHostNameIdxKey() {
		ICFSecHostNodeByHostNameIdxKey key =
			new CFSecBuffHostNodeByHostNameIdxKey();
		return( key );
	}

	public CFSecBuffHostNodeByHostNameIdxKey ensureByHostNameIdxKey(ICFSecHostNodeByHostNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffHostNodeByHostNameIdxKey) {
			return( (CFSecBuffHostNodeByHostNameIdxKey)key );
		}
		else {
			CFSecBuffHostNodeByHostNameIdxKey mapped = new CFSecBuffHostNodeByHostNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredHostName( key.getRequiredHostName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecHostNode newRec() {
		ICFSecHostNode rec =
			new CFSecBuffHostNode();
		return( rec );
	}

	public CFSecBuffHostNode ensureRec(ICFSecHostNode rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffHostNode) {
			return( (CFSecBuffHostNode)rec );
		}
		else {
			CFSecBuffHostNode mapped = new CFSecBuffHostNode();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecHostNodeH newHRec() {
		ICFSecHostNodeH hrec =
			new CFSecBuffHostNodeH();
		return( hrec );
	}

	public CFSecBuffHostNodeH ensureHRec(ICFSecHostNodeH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffHostNodeH) {
			return( (CFSecBuffHostNodeH)hrec );
		}
		else {
			CFSecBuffHostNodeH mapped = new CFSecBuffHostNodeH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
