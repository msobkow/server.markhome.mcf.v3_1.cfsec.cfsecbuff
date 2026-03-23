
// Description: Java 25 Default Factory implementation for SecClusGrpInc buffers

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
 *	CFSecBuffSecClusGrpIncFactory implementation of ICFSecSecClusGrpIncFactory for SecClusGrpInc
 */
public class CFSecBuffSecClusGrpIncDefaultFactory
	implements ICFSecSecClusGrpIncFactory
{
	public CFSecBuffSecClusGrpIncDefaultFactory() {
	}

    @Override
    public ICFSecSecClusGrpIncPKey newPKey() {
        ICFSecSecClusGrpIncPKey pkey =
            new CFSecBuffSecClusGrpIncPKey();
        return( pkey );
    }

	public CFSecBuffSecClusGrpIncPKey ensurePKey(ICFSecSecClusGrpIncPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpIncPKey) {
			return( (CFSecBuffSecClusGrpIncPKey)key );
		}
		else {
			CFSecBuffSecClusGrpIncPKey mapped = new CFSecBuffSecClusGrpIncPKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpIncHPKey newHPKey() {
		ICFSecSecClusGrpIncHPKey hpkey =
			new CFSecBuffSecClusGrpIncHPKey();
		return( hpkey );
	}

	public CFSecBuffSecClusGrpIncHPKey ensureHPKey(ICFSecSecClusGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecClusGrpIncHPKey) {
			return( (CFSecBuffSecClusGrpIncHPKey)key );
		}
		else {
			CFSecBuffSecClusGrpIncHPKey mapped = new CFSecBuffSecClusGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpIncByClusGrpIdxKey newByClusGrpIdxKey() {
		ICFSecSecClusGrpIncByClusGrpIdxKey key =
			new CFSecBuffSecClusGrpIncByClusGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpIncByClusGrpIdxKey ensureByClusGrpIdxKey(ICFSecSecClusGrpIncByClusGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpIncByClusGrpIdxKey) {
			return( (CFSecBuffSecClusGrpIncByClusGrpIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpIncByClusGrpIdxKey mapped = new CFSecBuffSecClusGrpIncByClusGrpIdxKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpIncByNameIdxKey newByNameIdxKey() {
		ICFSecSecClusGrpIncByNameIdxKey key =
			new CFSecBuffSecClusGrpIncByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpIncByNameIdxKey ensureByNameIdxKey(ICFSecSecClusGrpIncByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpIncByNameIdxKey) {
			return( (CFSecBuffSecClusGrpIncByNameIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpIncByNameIdxKey mapped = new CFSecBuffSecClusGrpIncByNameIdxKey();
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpInc newRec() {
		ICFSecSecClusGrpInc rec =
			new CFSecBuffSecClusGrpInc();
		return( rec );
	}

	public CFSecBuffSecClusGrpInc ensureRec(ICFSecSecClusGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecClusGrpInc) {
			return( (CFSecBuffSecClusGrpInc)rec );
		}
		else {
			CFSecBuffSecClusGrpInc mapped = new CFSecBuffSecClusGrpInc();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpIncH newHRec() {
		ICFSecSecClusGrpIncH hrec =
			new CFSecBuffSecClusGrpIncH();
		return( hrec );
	}

	public CFSecBuffSecClusGrpIncH ensureHRec(ICFSecSecClusGrpIncH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecClusGrpIncH) {
			return( (CFSecBuffSecClusGrpIncH)hrec );
		}
		else {
			CFSecBuffSecClusGrpIncH mapped = new CFSecBuffSecClusGrpIncH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
