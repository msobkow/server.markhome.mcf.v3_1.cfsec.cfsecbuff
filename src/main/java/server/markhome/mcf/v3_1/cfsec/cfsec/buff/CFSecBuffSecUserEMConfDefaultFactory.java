
// Description: Java 25 Default Factory implementation for SecUserEMConf buffers

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
 *	CFSecBuffSecUserEMConfFactory implementation of ICFSecSecUserEMConfFactory for SecUserEMConf
 */
public class CFSecBuffSecUserEMConfDefaultFactory
	implements ICFSecSecUserEMConfFactory
{
	public CFSecBuffSecUserEMConfDefaultFactory() {
	}

	@Override
	public ICFSecSecUserEMConfHPKey newHPKey() {
		ICFSecSecUserEMConfHPKey hpkey =
			new CFSecBuffSecUserEMConfHPKey();
		return( hpkey );
	}

	public CFSecBuffSecUserEMConfHPKey ensureHPKey(ICFSecSecUserEMConfHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecUserEMConfHPKey) {
			return( (CFSecBuffSecUserEMConfHPKey)key );
		}
		else {
			CFSecBuffSecUserEMConfHPKey mapped = new CFSecBuffSecUserEMConfHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConfByUUuid6IdxKey newByUUuid6IdxKey() {
		ICFSecSecUserEMConfByUUuid6IdxKey key =
			new CFSecBuffSecUserEMConfByUUuid6IdxKey();
		return( key );
	}

	public CFSecBuffSecUserEMConfByUUuid6IdxKey ensureByUUuid6IdxKey(ICFSecSecUserEMConfByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserEMConfByUUuid6IdxKey) {
			return( (CFSecBuffSecUserEMConfByUUuid6IdxKey)key );
		}
		else {
			CFSecBuffSecUserEMConfByUUuid6IdxKey mapped = new CFSecBuffSecUserEMConfByUUuid6IdxKey();
			mapped.setRequiredEMConfirmationUuid6( key.getRequiredEMConfirmationUuid6() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConfByConfEMAddrIdxKey newByConfEMAddrIdxKey() {
		ICFSecSecUserEMConfByConfEMAddrIdxKey key =
			new CFSecBuffSecUserEMConfByConfEMAddrIdxKey();
		return( key );
	}

	public CFSecBuffSecUserEMConfByConfEMAddrIdxKey ensureByConfEMAddrIdxKey(ICFSecSecUserEMConfByConfEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserEMConfByConfEMAddrIdxKey) {
			return( (CFSecBuffSecUserEMConfByConfEMAddrIdxKey)key );
		}
		else {
			CFSecBuffSecUserEMConfByConfEMAddrIdxKey mapped = new CFSecBuffSecUserEMConfByConfEMAddrIdxKey();
			mapped.setRequiredConfirmEMailAddr( key.getRequiredConfirmEMailAddr() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConfBySentStampIdxKey newBySentStampIdxKey() {
		ICFSecSecUserEMConfBySentStampIdxKey key =
			new CFSecBuffSecUserEMConfBySentStampIdxKey();
		return( key );
	}

	public CFSecBuffSecUserEMConfBySentStampIdxKey ensureBySentStampIdxKey(ICFSecSecUserEMConfBySentStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserEMConfBySentStampIdxKey) {
			return( (CFSecBuffSecUserEMConfBySentStampIdxKey)key );
		}
		else {
			CFSecBuffSecUserEMConfBySentStampIdxKey mapped = new CFSecBuffSecUserEMConfBySentStampIdxKey();
			mapped.setRequiredEMailSentStamp( key.getRequiredEMailSentStamp() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConfByNewAcctIdxKey newByNewAcctIdxKey() {
		ICFSecSecUserEMConfByNewAcctIdxKey key =
			new CFSecBuffSecUserEMConfByNewAcctIdxKey();
		return( key );
	}

	public CFSecBuffSecUserEMConfByNewAcctIdxKey ensureByNewAcctIdxKey(ICFSecSecUserEMConfByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserEMConfByNewAcctIdxKey) {
			return( (CFSecBuffSecUserEMConfByNewAcctIdxKey)key );
		}
		else {
			CFSecBuffSecUserEMConfByNewAcctIdxKey mapped = new CFSecBuffSecUserEMConfByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConf newRec() {
		ICFSecSecUserEMConf rec =
			new CFSecBuffSecUserEMConf();
		return( rec );
	}

	public CFSecBuffSecUserEMConf ensureRec(ICFSecSecUserEMConf rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUserEMConf) {
			return( (CFSecBuffSecUserEMConf)rec );
		}
		else {
			CFSecBuffSecUserEMConf mapped = new CFSecBuffSecUserEMConf();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserEMConfH newHRec() {
		ICFSecSecUserEMConfH hrec =
			new CFSecBuffSecUserEMConfH();
		return( hrec );
	}

	public CFSecBuffSecUserEMConfH ensureHRec(ICFSecSecUserEMConfH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecUserEMConfH) {
			return( (CFSecBuffSecUserEMConfH)hrec );
		}
		else {
			CFSecBuffSecUserEMConfH mapped = new CFSecBuffSecUserEMConfH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
