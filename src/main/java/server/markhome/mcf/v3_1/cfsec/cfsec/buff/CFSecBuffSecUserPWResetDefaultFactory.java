
// Description: Java 25 Default Factory implementation for SecUserPWReset buffers

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
 *	CFSecBuffSecUserPWResetFactory implementation of ICFSecSecUserPWResetFactory for SecUserPWReset
 */
public class CFSecBuffSecUserPWResetDefaultFactory
	implements ICFSecSecUserPWResetFactory
{
	public CFSecBuffSecUserPWResetDefaultFactory() {
	}

	@Override
	public ICFSecSecUserPWResetHPKey newHPKey() {
		ICFSecSecUserPWResetHPKey hpkey =
			new CFSecBuffSecUserPWResetHPKey();
		return( hpkey );
	}

	public CFSecBuffSecUserPWResetHPKey ensureHPKey(ICFSecSecUserPWResetHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecUserPWResetHPKey) {
			return( (CFSecBuffSecUserPWResetHPKey)key );
		}
		else {
			CFSecBuffSecUserPWResetHPKey mapped = new CFSecBuffSecUserPWResetHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWResetByUUuid6IdxKey newByUUuid6IdxKey() {
		ICFSecSecUserPWResetByUUuid6IdxKey key =
			new CFSecBuffSecUserPWResetByUUuid6IdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWResetByUUuid6IdxKey ensureByUUuid6IdxKey(ICFSecSecUserPWResetByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWResetByUUuid6IdxKey) {
			return( (CFSecBuffSecUserPWResetByUUuid6IdxKey)key );
		}
		else {
			CFSecBuffSecUserPWResetByUUuid6IdxKey mapped = new CFSecBuffSecUserPWResetByUUuid6IdxKey();
			mapped.setRequiredPasswordResetUuid6( key.getRequiredPasswordResetUuid6() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWResetBySentEMAddrIdxKey newBySentEMAddrIdxKey() {
		ICFSecSecUserPWResetBySentEMAddrIdxKey key =
			new CFSecBuffSecUserPWResetBySentEMAddrIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWResetBySentEMAddrIdxKey ensureBySentEMAddrIdxKey(ICFSecSecUserPWResetBySentEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWResetBySentEMAddrIdxKey) {
			return( (CFSecBuffSecUserPWResetBySentEMAddrIdxKey)key );
		}
		else {
			CFSecBuffSecUserPWResetBySentEMAddrIdxKey mapped = new CFSecBuffSecUserPWResetBySentEMAddrIdxKey();
			mapped.setRequiredSentToEMailAddr( key.getRequiredSentToEMailAddr() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWResetByNewAcctIdxKey newByNewAcctIdxKey() {
		ICFSecSecUserPWResetByNewAcctIdxKey key =
			new CFSecBuffSecUserPWResetByNewAcctIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPWResetByNewAcctIdxKey ensureByNewAcctIdxKey(ICFSecSecUserPWResetByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPWResetByNewAcctIdxKey) {
			return( (CFSecBuffSecUserPWResetByNewAcctIdxKey)key );
		}
		else {
			CFSecBuffSecUserPWResetByNewAcctIdxKey mapped = new CFSecBuffSecUserPWResetByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWReset newRec() {
		ICFSecSecUserPWReset rec =
			new CFSecBuffSecUserPWReset();
		return( rec );
	}

	public CFSecBuffSecUserPWReset ensureRec(ICFSecSecUserPWReset rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUserPWReset) {
			return( (CFSecBuffSecUserPWReset)rec );
		}
		else {
			CFSecBuffSecUserPWReset mapped = new CFSecBuffSecUserPWReset();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPWResetH newHRec() {
		ICFSecSecUserPWResetH hrec =
			new CFSecBuffSecUserPWResetH();
		return( hrec );
	}

	public CFSecBuffSecUserPWResetH ensureHRec(ICFSecSecUserPWResetH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecUserPWResetH) {
			return( (CFSecBuffSecUserPWResetH)hrec );
		}
		else {
			CFSecBuffSecUserPWResetH mapped = new CFSecBuffSecUserPWResetH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
