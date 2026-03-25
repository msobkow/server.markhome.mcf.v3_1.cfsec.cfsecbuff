
// Description: Java 25 Default Factory implementation for SecTentGrpMemb buffers

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
 *	CFSecBuffSecTentGrpMembFactory implementation of ICFSecSecTentGrpMembFactory for SecTentGrpMemb
 */
public class CFSecBuffSecTentGrpMembDefaultFactory
	implements ICFSecSecTentGrpMembFactory
{
	public CFSecBuffSecTentGrpMembDefaultFactory() {
	}

    @Override
    public ICFSecSecTentGrpMembPKey newPKey() {
        ICFSecSecTentGrpMembPKey pkey =
            new CFSecBuffSecTentGrpMembPKey();
        return( pkey );
    }

	public CFSecBuffSecTentGrpMembPKey ensurePKey(ICFSecSecTentGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpMembPKey) {
			return( (CFSecBuffSecTentGrpMembPKey)key );
		}
		else {
			CFSecBuffSecTentGrpMembPKey mapped = new CFSecBuffSecTentGrpMembPKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpMembHPKey newHPKey() {
		ICFSecSecTentGrpMembHPKey hpkey =
			new CFSecBuffSecTentGrpMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecTentGrpMembHPKey ensureHPKey(ICFSecSecTentGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecTentGrpMembHPKey) {
			return( (CFSecBuffSecTentGrpMembHPKey)key );
		}
		else {
			CFSecBuffSecTentGrpMembHPKey mapped = new CFSecBuffSecTentGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpMembByTentGrpIdxKey newByTentGrpIdxKey() {
		ICFSecSecTentGrpMembByTentGrpIdxKey key =
			new CFSecBuffSecTentGrpMembByTentGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpMembByTentGrpIdxKey ensureByTentGrpIdxKey(ICFSecSecTentGrpMembByTentGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpMembByTentGrpIdxKey) {
			return( (CFSecBuffSecTentGrpMembByTentGrpIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpMembByTentGrpIdxKey mapped = new CFSecBuffSecTentGrpMembByTentGrpIdxKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpMembByUserIdxKey newByUserIdxKey() {
		ICFSecSecTentGrpMembByUserIdxKey key =
			new CFSecBuffSecTentGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecTentGrpMembByUserIdxKey ensureByUserIdxKey(ICFSecSecTentGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecTentGrpMembByUserIdxKey) {
			return( (CFSecBuffSecTentGrpMembByUserIdxKey)key );
		}
		else {
			CFSecBuffSecTentGrpMembByUserIdxKey mapped = new CFSecBuffSecTentGrpMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpMemb newRec() {
		ICFSecSecTentGrpMemb rec =
			new CFSecBuffSecTentGrpMemb();
		return( rec );
	}

	public CFSecBuffSecTentGrpMemb ensureRec(ICFSecSecTentGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecTentGrpMemb) {
			return( (CFSecBuffSecTentGrpMemb)rec );
		}
		else {
			CFSecBuffSecTentGrpMemb mapped = new CFSecBuffSecTentGrpMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecTentGrpMembH newHRec() {
		ICFSecSecTentGrpMembH hrec =
			new CFSecBuffSecTentGrpMembH();
		return( hrec );
	}

	public CFSecBuffSecTentGrpMembH ensureHRec(ICFSecSecTentGrpMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecTentGrpMembH) {
			return( (CFSecBuffSecTentGrpMembH)hrec );
		}
		else {
			CFSecBuffSecTentGrpMembH mapped = new CFSecBuffSecTentGrpMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
