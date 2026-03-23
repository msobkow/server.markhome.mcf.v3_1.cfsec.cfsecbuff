
// Description: Java 25 Default Factory implementation for SecSysGrp buffers

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
 *	CFSecBuffSecSysGrpFactory implementation of ICFSecSecSysGrpFactory for SecSysGrp
 */
public class CFSecBuffSecSysGrpDefaultFactory
	implements ICFSecSecSysGrpFactory
{
	public CFSecBuffSecSysGrpDefaultFactory() {
	}

	@Override
	public ICFSecSecSysGrpHPKey newHPKey() {
		ICFSecSecSysGrpHPKey hpkey =
			new CFSecBuffSecSysGrpHPKey();
		return( hpkey );
	}

	public CFSecBuffSecSysGrpHPKey ensureHPKey(ICFSecSecSysGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecSysGrpHPKey) {
			return( (CFSecBuffSecSysGrpHPKey)key );
		}
		else {
			CFSecBuffSecSysGrpHPKey mapped = new CFSecBuffSecSysGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecSysGrpByUNameIdxKey key =
			new CFSecBuffSecSysGrpByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpByUNameIdxKey ensureByUNameIdxKey(ICFSecSecSysGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpByUNameIdxKey) {
			return( (CFSecBuffSecSysGrpByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpByUNameIdxKey mapped = new CFSecBuffSecSysGrpByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpBySecLevelIdxKey newBySecLevelIdxKey() {
		ICFSecSecSysGrpBySecLevelIdxKey key =
			new CFSecBuffSecSysGrpBySecLevelIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpBySecLevelIdxKey ensureBySecLevelIdxKey(ICFSecSecSysGrpBySecLevelIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpBySecLevelIdxKey) {
			return( (CFSecBuffSecSysGrpBySecLevelIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpBySecLevelIdxKey mapped = new CFSecBuffSecSysGrpBySecLevelIdxKey();
			mapped.setRequiredSecLevel( key.getRequiredSecLevel() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpBySecLevelNmIdxKey newBySecLevelNmIdxKey() {
		ICFSecSecSysGrpBySecLevelNmIdxKey key =
			new CFSecBuffSecSysGrpBySecLevelNmIdxKey();
		return( key );
	}

	public CFSecBuffSecSysGrpBySecLevelNmIdxKey ensureBySecLevelNmIdxKey(ICFSecSecSysGrpBySecLevelNmIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecSysGrpBySecLevelNmIdxKey) {
			return( (CFSecBuffSecSysGrpBySecLevelNmIdxKey)key );
		}
		else {
			CFSecBuffSecSysGrpBySecLevelNmIdxKey mapped = new CFSecBuffSecSysGrpBySecLevelNmIdxKey();
			mapped.setRequiredSecLevel( key.getRequiredSecLevel() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrp newRec() {
		ICFSecSecSysGrp rec =
			new CFSecBuffSecSysGrp();
		return( rec );
	}

	public CFSecBuffSecSysGrp ensureRec(ICFSecSecSysGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecSysGrp) {
			return( (CFSecBuffSecSysGrp)rec );
		}
		else {
			CFSecBuffSecSysGrp mapped = new CFSecBuffSecSysGrp();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecSysGrpH newHRec() {
		ICFSecSecSysGrpH hrec =
			new CFSecBuffSecSysGrpH();
		return( hrec );
	}

	public CFSecBuffSecSysGrpH ensureHRec(ICFSecSecSysGrpH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecSysGrpH) {
			return( (CFSecBuffSecSysGrpH)hrec );
		}
		else {
			CFSecBuffSecSysGrpH mapped = new CFSecBuffSecSysGrpH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
