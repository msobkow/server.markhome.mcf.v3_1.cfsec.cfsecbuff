
// Description: Java 25 Default Factory implementation for ISOCtryCcy buffers

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
 *	CFSecBuffISOCtryCcyFactory implementation of ICFSecISOCtryCcyFactory for ISOCtryCcy
 */
public class CFSecBuffISOCtryCcyDefaultFactory
	implements ICFSecISOCtryCcyFactory
{
	public CFSecBuffISOCtryCcyDefaultFactory() {
	}

    @Override
    public ICFSecISOCtryCcyPKey newPKey() {
        ICFSecISOCtryCcyPKey pkey =
            new CFSecBuffISOCtryCcyPKey();
        return( pkey );
    }

	public CFSecBuffISOCtryCcyPKey ensurePKey(ICFSecISOCtryCcyPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryCcyPKey) {
			return( (CFSecBuffISOCtryCcyPKey)key );
		}
		else {
			CFSecBuffISOCtryCcyPKey mapped = new CFSecBuffISOCtryCcyPKey();
			mapped.setRequiredContainerCtry( key.getRequiredISOCtryId() );
			mapped.setRequiredParentCcy( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryCcyHPKey newHPKey() {
		ICFSecISOCtryCcyHPKey hpkey =
			new CFSecBuffISOCtryCcyHPKey();
		return( hpkey );
	}

	public CFSecBuffISOCtryCcyHPKey ensureHPKey(ICFSecISOCtryCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffISOCtryCcyHPKey) {
			return( (CFSecBuffISOCtryCcyHPKey)key );
		}
		else {
			CFSecBuffISOCtryCcyHPKey mapped = new CFSecBuffISOCtryCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryCcyByCtryIdxKey newByCtryIdxKey() {
		ICFSecISOCtryCcyByCtryIdxKey key =
			new CFSecBuffISOCtryCcyByCtryIdxKey();
		return( key );
	}

	public CFSecBuffISOCtryCcyByCtryIdxKey ensureByCtryIdxKey(ICFSecISOCtryCcyByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryCcyByCtryIdxKey) {
			return( (CFSecBuffISOCtryCcyByCtryIdxKey)key );
		}
		else {
			CFSecBuffISOCtryCcyByCtryIdxKey mapped = new CFSecBuffISOCtryCcyByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryCcyByCcyIdxKey newByCcyIdxKey() {
		ICFSecISOCtryCcyByCcyIdxKey key =
			new CFSecBuffISOCtryCcyByCcyIdxKey();
		return( key );
	}

	public CFSecBuffISOCtryCcyByCcyIdxKey ensureByCcyIdxKey(ICFSecISOCtryCcyByCcyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCtryCcyByCcyIdxKey) {
			return( (CFSecBuffISOCtryCcyByCcyIdxKey)key );
		}
		else {
			CFSecBuffISOCtryCcyByCcyIdxKey mapped = new CFSecBuffISOCtryCcyByCcyIdxKey();
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryCcy newRec() {
		ICFSecISOCtryCcy rec =
			new CFSecBuffISOCtryCcy();
		return( rec );
	}

	public CFSecBuffISOCtryCcy ensureRec(ICFSecISOCtryCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffISOCtryCcy) {
			return( (CFSecBuffISOCtryCcy)rec );
		}
		else {
			CFSecBuffISOCtryCcy mapped = new CFSecBuffISOCtryCcy();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCtryCcyH newHRec() {
		ICFSecISOCtryCcyH hrec =
			new CFSecBuffISOCtryCcyH();
		return( hrec );
	}

	public CFSecBuffISOCtryCcyH ensureHRec(ICFSecISOCtryCcyH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffISOCtryCcyH) {
			return( (CFSecBuffISOCtryCcyH)hrec );
		}
		else {
			CFSecBuffISOCtryCcyH mapped = new CFSecBuffISOCtryCcyH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
