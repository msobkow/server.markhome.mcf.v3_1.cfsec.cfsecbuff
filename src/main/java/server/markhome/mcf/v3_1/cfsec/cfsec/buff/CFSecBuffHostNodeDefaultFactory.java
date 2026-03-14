
// Description: Java 25 Default Factory implementation for HostNode buffers

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
