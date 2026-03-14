
// Description: Java 25 Default Factory implementation for Service buffers

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
