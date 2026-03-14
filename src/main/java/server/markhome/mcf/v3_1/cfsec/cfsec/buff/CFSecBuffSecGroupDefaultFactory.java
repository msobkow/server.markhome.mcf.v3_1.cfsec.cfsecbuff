
// Description: Java 25 Default Factory implementation for SecGroup buffers

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
 *	CFSecBuffSecGroupFactory implementation of ICFSecSecGroupFactory for SecGroup
 */
public class CFSecBuffSecGroupDefaultFactory
	implements ICFSecSecGroupFactory
{
	public CFSecBuffSecGroupDefaultFactory() {
	}

	@Override
	public ICFSecSecGroupHPKey newHPKey() {
		ICFSecSecGroupHPKey hpkey =
			new CFSecBuffSecGroupHPKey();
		return( hpkey );
	}

	public CFSecBuffSecGroupHPKey ensureHPKey(ICFSecSecGroupHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecGroupHPKey) {
			return( (CFSecBuffSecGroupHPKey)key );
		}
		else {
			CFSecBuffSecGroupHPKey mapped = new CFSecBuffSecGroupHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecGroupId( key.getRequiredSecGroupId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGroupByClusterIdxKey newByClusterIdxKey() {
		ICFSecSecGroupByClusterIdxKey key =
			new CFSecBuffSecGroupByClusterIdxKey();
		return( key );
	}

	public CFSecBuffSecGroupByClusterIdxKey ensureByClusterIdxKey(ICFSecSecGroupByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGroupByClusterIdxKey) {
			return( (CFSecBuffSecGroupByClusterIdxKey)key );
		}
		else {
			CFSecBuffSecGroupByClusterIdxKey mapped = new CFSecBuffSecGroupByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGroupByClusterVisIdxKey newByClusterVisIdxKey() {
		ICFSecSecGroupByClusterVisIdxKey key =
			new CFSecBuffSecGroupByClusterVisIdxKey();
		return( key );
	}

	public CFSecBuffSecGroupByClusterVisIdxKey ensureByClusterVisIdxKey(ICFSecSecGroupByClusterVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGroupByClusterVisIdxKey) {
			return( (CFSecBuffSecGroupByClusterVisIdxKey)key );
		}
		else {
			CFSecBuffSecGroupByClusterVisIdxKey mapped = new CFSecBuffSecGroupByClusterVisIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredIsVisible( key.getRequiredIsVisible() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGroupByUNameIdxKey newByUNameIdxKey() {
		ICFSecSecGroupByUNameIdxKey key =
			new CFSecBuffSecGroupByUNameIdxKey();
		return( key );
	}

	public CFSecBuffSecGroupByUNameIdxKey ensureByUNameIdxKey(ICFSecSecGroupByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecGroupByUNameIdxKey) {
			return( (CFSecBuffSecGroupByUNameIdxKey)key );
		}
		else {
			CFSecBuffSecGroupByUNameIdxKey mapped = new CFSecBuffSecGroupByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGroup newRec() {
		ICFSecSecGroup rec =
			new CFSecBuffSecGroup();
		return( rec );
	}

	public CFSecBuffSecGroup ensureRec(ICFSecSecGroup rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecGroup) {
			return( (CFSecBuffSecGroup)rec );
		}
		else {
			CFSecBuffSecGroup mapped = new CFSecBuffSecGroup();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecGroupH newHRec() {
		ICFSecSecGroupH hrec =
			new CFSecBuffSecGroupH();
		return( hrec );
	}

	public CFSecBuffSecGroupH ensureHRec(ICFSecSecGroupH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecGroupH) {
			return( (CFSecBuffSecGroupH)hrec );
		}
		else {
			CFSecBuffSecGroupH mapped = new CFSecBuffSecGroupH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
