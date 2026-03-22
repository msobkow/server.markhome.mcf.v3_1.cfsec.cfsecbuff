
// Description: Java 25 Default Factory implementation for SecClusGrp buffers

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
 *	CFSecBuffSecClusGrpFactory implementation of ICFSecSecClusGrpFactory for SecClusGrp
 */
public class CFSecBuffSecClusGrpDefaultFactory
	implements ICFSecSecClusGrpFactory
{
	public CFSecBuffSecClusGrpDefaultFactory() {
	}

	@Override
	public ICFSecSecClusGrpHPKey newHPKey() {
		ICFSecSecClusGrpHPKey hpkey =
			new CFSecBuffSecClusGrpHPKey();
		return( hpkey );
	}

	public CFSecBuffSecClusGrpHPKey ensureHPKey(ICFSecSecClusGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecClusGrpHPKey) {
			return( (CFSecBuffSecClusGrpHPKey)key );
		}
		else {
			CFSecBuffSecClusGrpHPKey mapped = new CFSecBuffSecClusGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpByClusterIdxKey newByClusterIdxKey() {
		ICFSecSecClusGrpByClusterIdxKey key =
			new CFSecBuffSecClusGrpByClusterIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpByClusterIdxKey ensureByClusterIdxKey(ICFSecSecClusGrpByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpByClusterIdxKey) {
			return( (CFSecBuffSecClusGrpByClusterIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpByClusterIdxKey mapped = new CFSecBuffSecClusGrpByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpByNameIdxKey newByNameIdxKey() {
		ICFSecSecClusGrpByNameIdxKey key =
			new CFSecBuffSecClusGrpByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpByNameIdxKey ensureByNameIdxKey(ICFSecSecClusGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpByNameIdxKey) {
			return( (CFSecBuffSecClusGrpByNameIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpByNameIdxKey mapped = new CFSecBuffSecClusGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecClusGrpByUNameIdxKey key =
			new CFSecBuffSecClusGrpByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecClusGrpByUNameIdxKey ensureByUNameIdxKey(ICFSecSecClusGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecClusGrpByUNameIdxKey) {
			return( (CFSecBuffSecClusGrpByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecClusGrpByUNameIdxKey mapped = new CFSecBuffSecClusGrpByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrp newRec() {
		ICFSecSecClusGrp rec =
			new CFSecBuffSecClusGrp();
		return( rec );
	}

	public CFSecBuffSecClusGrp ensureRec(ICFSecSecClusGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecClusGrp) {
			return( (CFSecBuffSecClusGrp)rec );
		}
		else {
			CFSecBuffSecClusGrp mapped = new CFSecBuffSecClusGrp();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecClusGrpH newHRec() {
		ICFSecSecClusGrpH hrec =
			new CFSecBuffSecClusGrpH();
		return( hrec );
	}

	public CFSecBuffSecClusGrpH ensureHRec(ICFSecSecClusGrpH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecClusGrpH) {
			return( (CFSecBuffSecClusGrpH)hrec );
		}
		else {
			CFSecBuffSecClusGrpH mapped = new CFSecBuffSecClusGrpH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
