
// Description: Java 25 Default Factory implementation for SecGrpInc buffers

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
 *	CFSecBuffSecGrpIncFactory implementation of ICFSecSecGrpIncFactory for SecGrpInc
 */
public class CFSecBuffSecGrpIncDefaultFactory
	implements ICFSecSecGrpIncFactory
{
	public CFSecBuffSecGrpIncDefaultFactory() {
	}

	@Override
	public ICFSecSecGrpIncHPKey newHPKey() {
		ICFSecSecGrpIncHPKey hpkey =
			new CFSecBuffSecGrpIncHPKey();
		return( hpkey );
	}

	public CFSecBuffSecGrpIncHPKey ensureHPKey(ICFSecSecGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecGrpIncHPKey) {
			return( (CFSecBuffSecGrpIncHPKey)key );
		}
		else {
			CFSecBuffSecGrpIncHPKey mapped = new CFSecBuffSecGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecGrpIncId( key.getRequiredSecGrpIncId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpIncByClusterIdxKey newByClusterIdxKey() {
		ICFSecSecGrpIncByClusterIdxKey key =
			new CFSecBuffSecGrpIncByClusterIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpIncByClusterIdxKey ensureByClusterIdxKey(ICFSecSecGrpIncByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpIncByClusterIdxKey) {
			return( (CFSecBuffSecGrpIncByClusterIdxKey)key );
		}
		else {
			CFSecBuffSecGrpIncByClusterIdxKey mapped = new CFSecBuffSecGrpIncByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpIncByGroupIdxKey newByGroupIdxKey() {
		ICFSecSecGrpIncByGroupIdxKey key =
			new CFSecBuffSecGrpIncByGroupIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpIncByGroupIdxKey ensureByGroupIdxKey(ICFSecSecGrpIncByGroupIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpIncByGroupIdxKey) {
			return( (CFSecBuffSecGrpIncByGroupIdxKey)key );
		}
		else {
			CFSecBuffSecGrpIncByGroupIdxKey mapped = new CFSecBuffSecGrpIncByGroupIdxKey();
			mapped.setRequiredSecGroupId( key.getRequiredSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpIncByIncludeIdxKey newByIncludeIdxKey() {
		ICFSecSecGrpIncByIncludeIdxKey key =
			new CFSecBuffSecGrpIncByIncludeIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpIncByIncludeIdxKey ensureByIncludeIdxKey(ICFSecSecGrpIncByIncludeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpIncByIncludeIdxKey) {
			return( (CFSecBuffSecGrpIncByIncludeIdxKey)key );
		}
		else {
			CFSecBuffSecGrpIncByIncludeIdxKey mapped = new CFSecBuffSecGrpIncByIncludeIdxKey();
			mapped.setRequiredIncludeGroupId( key.getRequiredIncludeGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpIncByUIncludeIdxKey newByUIncludeIdxKey() {
		ICFSecSecGrpIncByUIncludeIdxKey key =
			new CFSecBuffSecGrpIncByUIncludeIdxKey();
		return( key );
	}

	public CFSecBuffSecGrpIncByUIncludeIdxKey ensureByUIncludeIdxKey(ICFSecSecGrpIncByUIncludeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGrpIncByUIncludeIdxKey) {
			return( (CFSecBuffSecGrpIncByUIncludeIdxKey)key );
		}
		else {
			CFSecBuffSecGrpIncByUIncludeIdxKey mapped = new CFSecBuffSecGrpIncByUIncludeIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredSecGroupId( key.getRequiredSecGroupId() );
			mapped.setRequiredIncludeGroupId( key.getRequiredIncludeGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpInc newRec() {
		ICFSecSecGrpInc rec =
			new CFSecBuffSecGrpInc();
		return( rec );
	}

	public CFSecBuffSecGrpInc ensureRec(ICFSecSecGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecGrpInc) {
			return( (CFSecBuffSecGrpInc)rec );
		}
		else {
			CFSecBuffSecGrpInc mapped = new CFSecBuffSecGrpInc();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGrpIncH newHRec() {
		ICFSecSecGrpIncH hrec =
			new CFSecBuffSecGrpIncH();
		return( hrec );
	}

	public CFSecBuffSecGrpIncH ensureHRec(ICFSecSecGrpIncH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecGrpIncH) {
			return( (CFSecBuffSecGrpIncH)hrec );
		}
		else {
			CFSecBuffSecGrpIncH mapped = new CFSecBuffSecGrpIncH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
