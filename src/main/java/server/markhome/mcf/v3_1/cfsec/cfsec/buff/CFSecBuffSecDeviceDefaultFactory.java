
// Description: Java 25 Default Factory implementation for SecDevice buffers

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
 *	CFSecBuffSecDeviceFactory implementation of ICFSecSecDeviceFactory for SecDevice
 */
public class CFSecBuffSecDeviceDefaultFactory
	implements ICFSecSecDeviceFactory
{
	public CFSecBuffSecDeviceDefaultFactory() {
	}

    @Override
    public ICFSecSecDevicePKey newPKey() {
        ICFSecSecDevicePKey pkey =
            new CFSecBuffSecDevicePKey();
        return( pkey );
    }

	public CFSecBuffSecDevicePKey ensurePKey(ICFSecSecDevicePKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecDevicePKey) {
			return( (CFSecBuffSecDevicePKey)key );
		}
		else {
			CFSecBuffSecDevicePKey mapped = new CFSecBuffSecDevicePKey();
			mapped.setRequiredContainerSecUser( key.getRequiredSecUserId() );
			mapped.setRequiredDevName( key.getRequiredDevName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecDeviceHPKey newHPKey() {
		ICFSecSecDeviceHPKey hpkey =
			new CFSecBuffSecDeviceHPKey();
		return( hpkey );
	}

	public CFSecBuffSecDeviceHPKey ensureHPKey(ICFSecSecDeviceHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffSecDeviceHPKey) {
			return( (CFSecBuffSecDeviceHPKey)key );
		}
		else {
			CFSecBuffSecDeviceHPKey mapped = new CFSecBuffSecDeviceHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredDevName( key.getRequiredDevName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecDeviceByNameIdxKey newByNameIdxKey() {
		ICFSecSecDeviceByNameIdxKey key =
			new CFSecBuffSecDeviceByNameIdxKey();
		return( key );
	}

	public CFSecBuffSecDeviceByNameIdxKey ensureByNameIdxKey(ICFSecSecDeviceByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecDeviceByNameIdxKey) {
			return( (CFSecBuffSecDeviceByNameIdxKey)key );
		}
		else {
			CFSecBuffSecDeviceByNameIdxKey mapped = new CFSecBuffSecDeviceByNameIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			mapped.setRequiredDevName( key.getRequiredDevName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecDeviceByUserIdxKey newByUserIdxKey() {
		ICFSecSecDeviceByUserIdxKey key =
			new CFSecBuffSecDeviceByUserIdxKey();
		return( key );
	}

	public CFSecBuffSecDeviceByUserIdxKey ensureByUserIdxKey(ICFSecSecDeviceByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecDeviceByUserIdxKey) {
			return( (CFSecBuffSecDeviceByUserIdxKey)key );
		}
		else {
			CFSecBuffSecDeviceByUserIdxKey mapped = new CFSecBuffSecDeviceByUserIdxKey();
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecDevice newRec() {
		ICFSecSecDevice rec =
			new CFSecBuffSecDevice();
		return( rec );
	}

	public CFSecBuffSecDevice ensureRec(ICFSecSecDevice rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecDevice) {
			return( (CFSecBuffSecDevice)rec );
		}
		else {
			CFSecBuffSecDevice mapped = new CFSecBuffSecDevice();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecSecDeviceH newHRec() {
		ICFSecSecDeviceH hrec =
			new CFSecBuffSecDeviceH();
		return( hrec );
	}

	public CFSecBuffSecDeviceH ensureHRec(ICFSecSecDeviceH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffSecDeviceH) {
			return( (CFSecBuffSecDeviceH)hrec );
		}
		else {
			CFSecBuffSecDeviceH mapped = new CFSecBuffSecDeviceH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
