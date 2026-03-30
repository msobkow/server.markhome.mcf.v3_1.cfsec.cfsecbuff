
// Description: Java 25 Default Factory implementation for SecUser buffers

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
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffSecUserFactory implementation of ICFSecSecUserFactory for SecUser
 */
public class CFSecBuffSecUserDefaultFactory
	implements ICFSecSecUserFactory
{
	public CFSecBuffSecUserDefaultFactory() {
	}

	@Override
	public ICFSecSecUserHPKey newHPKey() {
		ICFSecSecUserHPKey hpkey =
			new CFSecBuffSecUserHPKey();
		return( hpkey );
	}

	public CFSecBuffSecUserHPKey ensureHPKey(ICFSecSecUserHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecUserHPKey) {
			return( (CFSecBuffSecUserHPKey)key );
		}
		else {
			CFSecBuffSecUserHPKey mapped = new CFSecBuffSecUserHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByULoginIdxKey newByULoginIdxKey() {
		ICFSecSecUserByULoginIdxKey key =
			new CFSecBuffSecUserByULoginIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByULoginIdxKey ensureByULoginIdxKey(ICFSecSecUserByULoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByULoginIdxKey) {
			return( (CFSecBuffSecUserByULoginIdxKey)key );
		}
		else {
			CFSecBuffSecUserByULoginIdxKey mapped = new CFSecBuffSecUserByULoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserByEMAddrIdxKey newByEMAddrIdxKey() {
		ICFSecSecUserByEMAddrIdxKey key =
			new CFSecBuffSecUserByEMAddrIdxKey();
		return( key );
	}

	public CFSecBuffSecUserByEMAddrIdxKey ensureByEMAddrIdxKey(ICFSecSecUserByEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserByEMAddrIdxKey) {
			return( (CFSecBuffSecUserByEMAddrIdxKey)key );
		}
		else {
			CFSecBuffSecUserByEMAddrIdxKey mapped = new CFSecBuffSecUserByEMAddrIdxKey();
			mapped.setRequiredEMailAddress( key.getRequiredEMailAddress() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUser newRec() {
		ICFSecSecUser rec =
			new CFSecBuffSecUser();
		return( rec );
	}

	public CFSecBuffSecUser ensureRec(ICFSecSecUser rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUser) {
			return( (CFSecBuffSecUser)rec );
		}
		else {
			CFSecBuffSecUser mapped = new CFSecBuffSecUser();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserH newHRec() {
		ICFSecSecUserH hrec =
			new CFSecBuffSecUserH();
		return( hrec );
	}

	public CFSecBuffSecUserH ensureHRec(ICFSecSecUserH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecUserH) {
			return( (CFSecBuffSecUserH)hrec );
		}
		else {
			CFSecBuffSecUserH mapped = new CFSecBuffSecUserH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
