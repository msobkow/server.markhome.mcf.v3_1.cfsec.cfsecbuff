
// Description: Java 25 Default Factory implementation for ISOCcy buffers

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
 *	CFSecBuffISOCcyFactory implementation of ICFSecISOCcyFactory for ISOCcy
 */
public class CFSecBuffISOCcyDefaultFactory
	implements ICFSecISOCcyFactory
{
	public CFSecBuffISOCcyDefaultFactory() {
	}

	@Override
	public ICFSecISOCcyHPKey newHPKey() {
		ICFSecISOCcyHPKey hpkey =
			new CFSecBuffISOCcyHPKey();
		return( hpkey );
	}

	public CFSecBuffISOCcyHPKey ensureHPKey(ICFSecISOCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffISOCcyHPKey) {
			return( (CFSecBuffISOCcyHPKey)key );
		}
		else {
			CFSecBuffISOCcyHPKey mapped = new CFSecBuffISOCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCcyByCcyCdIdxKey newByCcyCdIdxKey() {
		ICFSecISOCcyByCcyCdIdxKey key =
			new CFSecBuffISOCcyByCcyCdIdxKey();
		return( key );
	}

	public CFSecBuffISOCcyByCcyCdIdxKey ensureByCcyCdIdxKey(ICFSecISOCcyByCcyCdIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCcyByCcyCdIdxKey) {
			return( (CFSecBuffISOCcyByCcyCdIdxKey)key );
		}
		else {
			CFSecBuffISOCcyByCcyCdIdxKey mapped = new CFSecBuffISOCcyByCcyCdIdxKey();
			mapped.setRequiredISOCode( key.getRequiredISOCode() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCcyByCcyNmIdxKey newByCcyNmIdxKey() {
		ICFSecISOCcyByCcyNmIdxKey key =
			new CFSecBuffISOCcyByCcyNmIdxKey();
		return( key );
	}

	public CFSecBuffISOCcyByCcyNmIdxKey ensureByCcyNmIdxKey(ICFSecISOCcyByCcyNmIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOCcyByCcyNmIdxKey) {
			return( (CFSecBuffISOCcyByCcyNmIdxKey)key );
		}
		else {
			CFSecBuffISOCcyByCcyNmIdxKey mapped = new CFSecBuffISOCcyByCcyNmIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCcy newRec() {
		ICFSecISOCcy rec =
			new CFSecBuffISOCcy();
		return( rec );
	}

	public CFSecBuffISOCcy ensureRec(ICFSecISOCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffISOCcy) {
			return( (CFSecBuffISOCcy)rec );
		}
		else {
			CFSecBuffISOCcy mapped = new CFSecBuffISOCcy();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecISOCcyH newHRec() {
		ICFSecISOCcyH hrec =
			new CFSecBuffISOCcyH();
		return( hrec );
	}

	public CFSecBuffISOCcyH ensureHRec(ICFSecISOCcyH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffISOCcyH) {
			return( (CFSecBuffISOCcyH)hrec );
		}
		else {
			CFSecBuffISOCcyH mapped = new CFSecBuffISOCcyH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
