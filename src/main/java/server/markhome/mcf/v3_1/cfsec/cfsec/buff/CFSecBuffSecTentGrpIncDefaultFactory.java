
// Description: Java 25 Default Factory implementation for SecTentGrpInc buffers

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
 *	CFSecBuffSecTentGrpIncFactory implementation of ICFSecSecTentGrpIncFactory for SecTentGrpInc
 */
public class CFSecBuffSecTentGrpIncDefaultFactory
	implements ICFSecSecTentGrpIncFactory
{
	public CFSecBuffSecTentGrpIncDefaultFactory() {
	}

    @Override
    public ICFSecSecTentGrpIncPKey newPKey() {
        ICFSecSecTentGrpIncPKey pkey =
            new CFSecBuffSecTentGrpIncPKey();
        return( pkey );
    }

	public CFSecBuffSecTentGrpIncPKey ensurePKey(ICFSecSecTentGrpIncPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpIncPKey) {
			return( (CFSecBuffSecTentGrpIncPKey)key );
		}
		else {
			CFSecBuffSecTentGrpIncPKey mapped = new CFSecBuffSecTentGrpIncPKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpIncHPKey newHPKey() {
		ICFSecSecTentGrpIncHPKey hpkey =
			new CFSecBuffSecTentGrpIncHPKey();
		return( hpkey );
	}

	public CFSecBuffSecTentGrpIncHPKey ensureHPKey(ICFSecSecTentGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecTentGrpIncHPKey) {
			return( (CFSecBuffSecTentGrpIncHPKey)key );
		}
		else {
			CFSecBuffSecTentGrpIncHPKey mapped = new CFSecBuffSecTentGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpIncByTentGrpIdxKey newByTentGrpIdxKey() {
		ICFSecSecTentGrpIncByTentGrpIdxKey key =
			new CFSecBuffSecTentGrpIncByTentGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpIncByTentGrpIdxKey ensureByTentGrpIdxKey(ICFSecSecTentGrpIncByTentGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpIncByTentGrpIdxKey) {
			return( (CFSecBuffSecTentGrpIncByTentGrpIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpIncByTentGrpIdxKey mapped = new CFSecBuffSecTentGrpIncByTentGrpIdxKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpIncByNameIdxKey newByNameIdxKey() {
		ICFSecSecTentGrpIncByNameIdxKey key =
			new CFSecBuffSecTentGrpIncByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpIncByNameIdxKey ensureByNameIdxKey(ICFSecSecTentGrpIncByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpIncByNameIdxKey) {
			return( (CFSecBuffSecTentGrpIncByNameIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpIncByNameIdxKey mapped = new CFSecBuffSecTentGrpIncByNameIdxKey();
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpInc newRec() {
		ICFSecSecTentGrpInc rec =
			new CFSecBuffSecTentGrpInc();
		return( rec );
	}

	public CFSecBuffSecTentGrpInc ensureRec(ICFSecSecTentGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecTentGrpInc) {
			return( (CFSecBuffSecTentGrpInc)rec );
		}
		else {
			CFSecBuffSecTentGrpInc mapped = new CFSecBuffSecTentGrpInc();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpIncH newHRec() {
		ICFSecSecTentGrpIncH hrec =
			new CFSecBuffSecTentGrpIncH();
		return( hrec );
	}

	public CFSecBuffSecTentGrpIncH ensureHRec(ICFSecSecTentGrpIncH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecTentGrpIncH) {
			return( (CFSecBuffSecTentGrpIncH)hrec );
		}
		else {
			CFSecBuffSecTentGrpIncH mapped = new CFSecBuffSecTentGrpIncH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
