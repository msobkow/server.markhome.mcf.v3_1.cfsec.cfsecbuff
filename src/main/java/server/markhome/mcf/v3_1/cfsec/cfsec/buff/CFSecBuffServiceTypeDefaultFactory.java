
// Description: Java 25 Default Factory implementation for ServiceType buffers

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
 *	CFSecBuffServiceTypeFactory implementation of ICFSecServiceTypeFactory for ServiceType
 */
public class CFSecBuffServiceTypeDefaultFactory
	implements ICFSecServiceTypeFactory
{
	public CFSecBuffServiceTypeDefaultFactory() {
	}

	@Override
	public ICFSecServiceTypeHPKey newHPKey() {
		ICFSecServiceTypeHPKey hpkey =
			new CFSecBuffServiceTypeHPKey();
		return( hpkey );
	}

	public CFSecBuffServiceTypeHPKey ensureHPKey(ICFSecServiceTypeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffServiceTypeHPKey) {
			return( (CFSecBuffServiceTypeHPKey)key );
		}
		else {
			CFSecBuffServiceTypeHPKey mapped = new CFSecBuffServiceTypeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredServiceTypeId( key.getRequiredServiceTypeId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceTypeByUDescrIdxKey newByUDescrIdxKey() {
		ICFSecServiceTypeByUDescrIdxKey key =
			new CFSecBuffServiceTypeByUDescrIdxKey();
		return( key );
	}

	public CFSecBuffServiceTypeByUDescrIdxKey ensureByUDescrIdxKey(ICFSecServiceTypeByUDescrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffServiceTypeByUDescrIdxKey) {
			return( (CFSecBuffServiceTypeByUDescrIdxKey)key );
		}
		else {
			CFSecBuffServiceTypeByUDescrIdxKey mapped = new CFSecBuffServiceTypeByUDescrIdxKey();
			mapped.setRequiredDescription( key.getRequiredDescription() );
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceType newRec() {
		ICFSecServiceType rec =
			new CFSecBuffServiceType();
		return( rec );
	}

	public CFSecBuffServiceType ensureRec(ICFSecServiceType rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffServiceType) {
			return( (CFSecBuffServiceType)rec );
		}
		else {
			CFSecBuffServiceType mapped = new CFSecBuffServiceType();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecServiceTypeH newHRec() {
		ICFSecServiceTypeH hrec =
			new CFSecBuffServiceTypeH();
		return( hrec );
	}

	public CFSecBuffServiceTypeH ensureHRec(ICFSecServiceTypeH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffServiceTypeH) {
			return( (CFSecBuffServiceTypeH)hrec );
		}
		else {
			CFSecBuffServiceTypeH mapped = new CFSecBuffServiceTypeH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
