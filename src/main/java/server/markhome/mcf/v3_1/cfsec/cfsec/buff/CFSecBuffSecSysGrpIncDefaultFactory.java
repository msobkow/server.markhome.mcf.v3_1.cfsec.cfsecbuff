
// Description: Java 25 Default Factory implementation for SecSysGrpInc buffers

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
 *	CFSecBuffSecSysGrpIncFactory implementation of ICFSecSecSysGrpIncFactory for SecSysGrpInc
 */
public class CFSecBuffSecSysGrpIncDefaultFactory
	implements ICFSecSecSysGrpIncFactory
{
	public CFSecBuffSecSysGrpIncDefaultFactory() {
	}

    @Override
    public ICFSecSecSysGrpIncPKey newPKey() {
        ICFSecSecSysGrpIncPKey pkey =
            new CFSecBuffSecSysGrpIncPKey();
        return( pkey );
    }

	public CFSecBuffSecSysGrpIncPKey ensurePKey(ICFSecSecSysGrpIncPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpIncPKey) {
			return( (CFSecBuffSecSysGrpIncPKey)key );
		}
		else {
			CFSecBuffSecSysGrpIncPKey mapped = new CFSecBuffSecSysGrpIncPKey();
			mapped.setRequiredContainerGroup( key.getRequiredSecSysGrpId() );
			mapped.setRequiredParentSubGroup( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpIncHPKey newHPKey() {
		ICFSecSecSysGrpIncHPKey hpkey =
			new CFSecBuffSecSysGrpIncHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysGrpIncHPKey ensureHPKey(ICFSecSecSysGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysGrpIncHPKey) {
			return( (CFSecBuffSecSysGrpIncHPKey)key );
		}
		else {
			CFSecBuffSecSysGrpIncHPKey mapped = new CFSecBuffSecSysGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpIncBySysGrpIdxKey newBySysGrpIdxKey() {
		ICFSecSecSysGrpIncBySysGrpIdxKey key =
			new CFSecBuffSecSysGrpIncBySysGrpIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpIncBySysGrpIdxKey ensureBySysGrpIdxKey(ICFSecSecSysGrpIncBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpIncBySysGrpIdxKey) {
			return( (CFSecBuffSecSysGrpIncBySysGrpIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpIncBySysGrpIdxKey mapped = new CFSecBuffSecSysGrpIncBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpIncByNameIdxKey newByNameIdxKey() {
		ICFSecSecSysGrpIncByNameIdxKey key =
			new CFSecBuffSecSysGrpIncByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpIncByNameIdxKey ensureByNameIdxKey(ICFSecSecSysGrpIncByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpIncByNameIdxKey) {
			return( (CFSecBuffSecSysGrpIncByNameIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpIncByNameIdxKey mapped = new CFSecBuffSecSysGrpIncByNameIdxKey();
			mapped.setRequiredIncName( key.getRequiredIncName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpInc newRec() {
		ICFSecSecSysGrpInc rec =
			new CFSecBuffSecSysGrpInc();
		return( rec );
	}

	public CFSecBuffSecSysGrpInc ensureRec(ICFSecSecSysGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysGrpInc) {
			return( (CFSecBuffSecSysGrpInc)rec );
		}
		else {
			CFSecBuffSecSysGrpInc mapped = new CFSecBuffSecSysGrpInc();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpIncH newHRec() {
		ICFSecSecSysGrpIncH hrec =
			new CFSecBuffSecSysGrpIncH();
		return( hrec );
	}

	public CFSecBuffSecSysGrpIncH ensureHRec(ICFSecSecSysGrpIncH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysGrpIncH) {
			return( (CFSecBuffSecSysGrpIncH)hrec );
		}
		else {
			CFSecBuffSecSysGrpIncH mapped = new CFSecBuffSecSysGrpIncH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
