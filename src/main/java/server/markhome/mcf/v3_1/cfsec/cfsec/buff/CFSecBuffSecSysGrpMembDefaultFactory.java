
// Description: Java 25 Default Factory implementation for SecSysGrpMemb buffers

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
 *	CFSecBuffSecSysGrpMembFactory implementation of ICFSecSecSysGrpMembFactory for SecSysGrpMemb
 */
public class CFSecBuffSecSysGrpMembDefaultFactory
	implements ICFSecSecSysGrpMembFactory
{
	public CFSecBuffSecSysGrpMembDefaultFactory() {
	}

    @Override
    public ICFSecSecSysGrpMembPKey newPKey() {
        ICFSecSecSysGrpMembPKey pkey =
            new CFSecBuffSecSysGrpMembPKey();
        return( pkey );
    }

	public CFSecBuffSecSysGrpMembPKey ensurePKey(ICFSecSecSysGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpMembPKey) {
			return( (CFSecBuffSecSysGrpMembPKey)key );
		}
		else {
			CFSecBuffSecSysGrpMembPKey mapped = new CFSecBuffSecSysGrpMembPKey();
			mapped.setRequiredContainerGroup( key.getRequiredSecSysGrpId() );
			mapped.setRequiredParentUser( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpMembHPKey newHPKey() {
		ICFSecSecSysGrpMembHPKey hpkey =
			new CFSecBuffSecSysGrpMembHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysGrpMembHPKey ensureHPKey(ICFSecSecSysGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysGrpMembHPKey) {
			return( (CFSecBuffSecSysGrpMembHPKey)key );
		}
		else {
			CFSecBuffSecSysGrpMembHPKey mapped = new CFSecBuffSecSysGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpMembBySysGrpIdxKey newBySysGrpIdxKey() {
		ICFSecSecSysGrpMembBySysGrpIdxKey key =
			new CFSecBuffSecSysGrpMembBySysGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpMembBySysGrpIdxKey ensureBySysGrpIdxKey(ICFSecSecSysGrpMembBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpMembBySysGrpIdxKey) {
			return( (CFSecBuffSecSysGrpMembBySysGrpIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpMembBySysGrpIdxKey mapped = new CFSecBuffSecSysGrpMembBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpMembByUserIdxKey newByUserIdxKey() {
		ICFSecSecSysGrpMembByUserIdxKey key =
			new CFSecBuffSecSysGrpMembByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpMembByUserIdxKey ensureByUserIdxKey(ICFSecSecSysGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpMembByUserIdxKey) {
			return( (CFSecBuffSecSysGrpMembByUserIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpMembByUserIdxKey mapped = new CFSecBuffSecSysGrpMembByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpMemb newRec() {
		ICFSecSecSysGrpMemb rec =
			new CFSecBuffSecSysGrpMemb();
		return( rec );
	}

	public CFSecBuffSecSysGrpMemb ensureRec(ICFSecSecSysGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysGrpMemb) {
			return( (CFSecBuffSecSysGrpMemb)rec );
		}
		else {
			CFSecBuffSecSysGrpMemb mapped = new CFSecBuffSecSysGrpMemb();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpMembH newHRec() {
		ICFSecSecSysGrpMembH hrec =
			new CFSecBuffSecSysGrpMembH();
		return( hrec );
	}

	public CFSecBuffSecSysGrpMembH ensureHRec(ICFSecSecSysGrpMembH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysGrpMembH) {
			return( (CFSecBuffSecSysGrpMembH)hrec );
		}
		else {
			CFSecBuffSecSysGrpMembH mapped = new CFSecBuffSecSysGrpMembH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
