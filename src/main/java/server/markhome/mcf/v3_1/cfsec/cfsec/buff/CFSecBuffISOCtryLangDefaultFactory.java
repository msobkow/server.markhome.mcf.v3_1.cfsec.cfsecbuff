
// Description: Java 25 Default Factory implementation for ISOCtryLang buffers

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
 *	CFSecBuffISOCtryLangFactory implementation of ICFSecISOCtryLangFactory for ISOCtryLang
 */
public class CFSecBuffISOCtryLangDefaultFactory
	implements ICFSecISOCtryLangFactory
{
	public CFSecBuffISOCtryLangDefaultFactory() {
	}

    @Override
    public ICFSecISOCtryLangPKey newPKey() {
        ICFSecISOCtryLangPKey pkey =
            new CFSecBuffISOCtryLangPKey();
        return( pkey );
    }

	public CFSecBuffISOCtryLangPKey ensurePKey(ICFSecISOCtryLangPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryLangPKey) {
			return( (CFSecBuffISOCtryLangPKey)key );
		}
		else {
			CFSecBuffISOCtryLangPKey mapped = new CFSecBuffISOCtryLangPKey();
			mapped.setRequiredContainerCtry( key.getRequiredISOCtryId() );
			mapped.setRequiredParentLang( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryLangHPKey newHPKey() {
		ICFSecISOCtryLangHPKey hpkey =
			new CFSecBuffISOCtryLangHPKey();
		return( hpkey );
	}

	public CFSecBuffISOCtryLangHPKey ensureHPKey(ICFSecISOCtryLangHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffISOCtryLangHPKey) {
			return( (CFSecBuffISOCtryLangHPKey)key );
		}
		else {
			CFSecBuffISOCtryLangHPKey mapped = new CFSecBuffISOCtryLangHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryLangByCtryIdxKey newByCtryIdxKey() {
		ICFSecISOCtryLangByCtryIdxKey key =
			new CFSecBuffISOCtryLangByCtryIdxKey();
		return( key );
	}

	public CFSecBuffISOCtryLangByCtryIdxKey ensureByCtryIdxKey(ICFSecISOCtryLangByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryLangByCtryIdxKey) {
			return( (CFSecBuffISOCtryLangByCtryIdxKey)key );
		}
		else {
			CFSecBuffISOCtryLangByCtryIdxKey mapped = new CFSecBuffISOCtryLangByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryLangByLangIdxKey newByLangIdxKey() {
		ICFSecISOCtryLangByLangIdxKey key =
			new CFSecBuffISOCtryLangByLangIdxKey();
		return( key );
	}

	public CFSecBuffISOCtryLangByLangIdxKey ensureByLangIdxKey(ICFSecISOCtryLangByLangIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryLangByLangIdxKey) {
			return( (CFSecBuffISOCtryLangByLangIdxKey)key );
		}
		else {
			CFSecBuffISOCtryLangByLangIdxKey mapped = new CFSecBuffISOCtryLangByLangIdxKey();
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryLang newRec() {
		ICFSecISOCtryLang rec =
			new CFSecBuffISOCtryLang();
		return( rec );
	}

	public CFSecBuffISOCtryLang ensureRec(ICFSecISOCtryLang rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffISOCtryLang) {
			return( (CFSecBuffISOCtryLang)rec );
		}
		else {
			CFSecBuffISOCtryLang mapped = new CFSecBuffISOCtryLang();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryLangH newHRec() {
		ICFSecISOCtryLangH hrec =
			new CFSecBuffISOCtryLangH();
		return( hrec );
	}

	public CFSecBuffISOCtryLangH ensureHRec(ICFSecISOCtryLangH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffISOCtryLangH) {
			return( (CFSecBuffISOCtryLangH)hrec );
		}
		else {
			CFSecBuffISOCtryLangH mapped = new CFSecBuffISOCtryLangH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
