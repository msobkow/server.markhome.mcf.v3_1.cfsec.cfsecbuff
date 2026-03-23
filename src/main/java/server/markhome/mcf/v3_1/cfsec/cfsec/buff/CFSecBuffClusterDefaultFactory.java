
// Description: Java 25 Default Factory implementation for Cluster buffers

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
 *	CFSecBuffClusterFactory implementation of ICFSecClusterFactory for Cluster
 */
public class CFSecBuffClusterDefaultFactory
	implements ICFSecClusterFactory
{
	public CFSecBuffClusterDefaultFactory() {
	}

	@Override
	public ICFSecClusterHPKey newHPKey() {
		ICFSecClusterHPKey hpkey =
			new CFSecBuffClusterHPKey();
		return( hpkey );
	}

	public CFSecBuffClusterHPKey ensureHPKey(ICFSecClusterHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffClusterHPKey) {
			return( (CFSecBuffClusterHPKey)key );
		}
		else {
			CFSecBuffClusterHPKey mapped = new CFSecBuffClusterHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecClusterByUDomNameIdxKey newByUDomNameIdxKey() {
		ICFSecClusterByUDomNameIdxKey key =
			new CFSecBuffClusterByUDomNameIdxKey();
		return( key );
	}

	public CFSecBuffClusterByUDomNameIdxKey ensureByUDomNameIdxKey(ICFSecClusterByUDomNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffClusterByUDomNameIdxKey) {
			return( (CFSecBuffClusterByUDomNameIdxKey)key );
		}
		else {
			CFSecBuffClusterByUDomNameIdxKey mapped = new CFSecBuffClusterByUDomNameIdxKey();
			mapped.setRequiredFullDomName( key.getRequiredFullDomName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecClusterByUDescrIdxKey newByUDescrIdxKey() {
		ICFSecClusterByUDescrIdxKey key =
			new CFSecBuffClusterByUDescrIdxKey();
		return( key );
	}

	public CFSecBuffClusterByUDescrIdxKey ensureByUDescrIdxKey(ICFSecClusterByUDescrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffClusterByUDescrIdxKey) {
			return( (CFSecBuffClusterByUDescrIdxKey)key );
		}
		else {
			CFSecBuffClusterByUDescrIdxKey mapped = new CFSecBuffClusterByUDescrIdxKey();
			mapped.setRequiredDescription( key.getRequiredDescription() );
			return( mapped );
		}
	}

	@Override
	public ICFSecCluster newRec() {
		ICFSecCluster rec =
			new CFSecBuffCluster();
		return( rec );
	}

	public CFSecBuffCluster ensureRec(ICFSecCluster rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffCluster) {
			return( (CFSecBuffCluster)rec );
		}
		else {
			CFSecBuffCluster mapped = new CFSecBuffCluster();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecClusterH newHRec() {
		ICFSecClusterH hrec =
			new CFSecBuffClusterH();
		return( hrec );
	}

	public CFSecBuffClusterH ensureHRec(ICFSecClusterH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffClusterH) {
			return( (CFSecBuffClusterH)hrec );
		}
		else {
			CFSecBuffClusterH mapped = new CFSecBuffClusterH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
