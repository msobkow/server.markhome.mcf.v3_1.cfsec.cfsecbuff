
// Description: Java 25 Default Factory implementation for SecGrpMemb buffers

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
