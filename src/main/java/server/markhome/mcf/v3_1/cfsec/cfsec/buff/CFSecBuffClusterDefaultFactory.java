
// Description: Java 25 Default Factory implementation for Cluster buffers

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	This file is part of Mark's Code Fractal CFSec.
 *	
 *	Mark's Code Fractal CFSec is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFSec is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFSec is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFSec.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
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
