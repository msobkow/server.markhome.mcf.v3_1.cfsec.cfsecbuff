
// Description: Java 25 Default Factory implementation for TSecGrpInc buffers

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
