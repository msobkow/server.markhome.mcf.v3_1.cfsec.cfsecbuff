
// Description: Java 25 Default Factory implementation for SecClusGrpMemb buffers

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
 *	CFSecBuffSecClusGrpMembFactory implementation of ICFSecSecClusGrpMembFactory for SecClusGrpMemb
 */
public class CFSecBuffSecClusGrpMembDefaultFactory
	implements ICFSecSecClusGrpMembFactory
{
	public CFSecBuffSecClusGrpMembDefaultFactory() {
	}

    @Override
    public ICFSecSecClusGrpMembPKey newPKey() {
        ICFSecSecClusGrpMembPKey pkey =
            new CFSecBuffSecClusGrpMembPKey();
        return( pkey );
    }

	public CFSecBuffSecClusGrpMembPKey ensurePKey(ICFSecSecClusGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpMembPKey) {
			return( (CFSecBuffSecClusGrpMembPKey)key );
		}
		else {
			CFSecBuffSecClusGrpMembPKey mapped = new CFSecBuffSecClusGrpMembPKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpMembHPKey newHPKey() {
		ICFSecSecClusGrpMembHPKey hpkey =
			new CFSecBuffSecClusGrpMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecClusGrpMembHPKey ensureHPKey(ICFSecSecClusGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecClusGrpMembHPKey) {
			return( (CFSecBuffSecClusGrpMembHPKey)key );
		}
		else {
			CFSecBuffSecClusGrpMembHPKey mapped = new CFSecBuffSecClusGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpMembByClusGrpIdxKey newByClusGrpIdxKey() {
		ICFSecSecClusGrpMembByClusGrpIdxKey key =
			new CFSecBuffSecClusGrpMembByClusGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpMembByClusGrpIdxKey ensureByClusGrpIdxKey(ICFSecSecClusGrpMembByClusGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpMembByClusGrpIdxKey) {
			return( (CFSecBuffSecClusGrpMembByClusGrpIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpMembByClusGrpIdxKey mapped = new CFSecBuffSecClusGrpMembByClusGrpIdxKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpMembByUserIdxKey newByUserIdxKey() {
		ICFSecSecClusGrpMembByUserIdxKey key =
			new CFSecBuffSecClusGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpMembByUserIdxKey ensureByUserIdxKey(ICFSecSecClusGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpMembByUserIdxKey) {
			return( (CFSecBuffSecClusGrpMembByUserIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpMembByUserIdxKey mapped = new CFSecBuffSecClusGrpMembByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpMemb newRec() {
		ICFSecSecClusGrpMemb rec =
			new CFSecBuffSecClusGrpMemb();
		return( rec );
	}

	public CFSecBuffSecClusGrpMemb ensureRec(ICFSecSecClusGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecClusGrpMemb) {
			return( (CFSecBuffSecClusGrpMemb)rec );
		}
		else {
			CFSecBuffSecClusGrpMemb mapped = new CFSecBuffSecClusGrpMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpMembH newHRec() {
		ICFSecSecClusGrpMembH hrec =
			new CFSecBuffSecClusGrpMembH();
		return( hrec );
	}

	public CFSecBuffSecClusGrpMembH ensureHRec(ICFSecSecClusGrpMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecClusGrpMembH) {
			return( (CFSecBuffSecClusGrpMembH)hrec );
		}
		else {
			CFSecBuffSecClusGrpMembH mapped = new CFSecBuffSecClusGrpMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
