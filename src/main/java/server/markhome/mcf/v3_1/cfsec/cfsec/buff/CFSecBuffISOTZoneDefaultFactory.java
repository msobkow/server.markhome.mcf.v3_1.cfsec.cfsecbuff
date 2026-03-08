
// Description: Java 25 Default Factory implementation for ISOTZone buffers

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
 *	CFSecBuffISOTZoneFactory implementation of ICFSecISOTZoneFactory for ISOTZone
 */
public class CFSecBuffISOTZoneDefaultFactory
	implements ICFSecISOTZoneFactory
{
	public CFSecBuffISOTZoneDefaultFactory() {
	}

	@Override
	public ICFSecISOTZoneHPKey newHPKey() {
		ICFSecISOTZoneHPKey hpkey =
			new CFSecBuffISOTZoneHPKey();
		return( hpkey );
	}

	public CFSecBuffISOTZoneHPKey ensureHPKey(ICFSecISOTZoneHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof CFSecBuffISOTZoneHPKey) {
			return( (CFSecBuffISOTZoneHPKey)key );
		}
		else {
			CFSecBuffISOTZoneHPKey mapped = new CFSecBuffISOTZoneHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOTZoneId( key.getRequiredISOTZoneId() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOTZoneByOffsetIdxKey newByOffsetIdxKey() {
		ICFSecISOTZoneByOffsetIdxKey key =
			new CFSecBuffISOTZoneByOffsetIdxKey();
		return( key );
	}

	public CFSecBuffISOTZoneByOffsetIdxKey ensureByOffsetIdxKey(ICFSecISOTZoneByOffsetIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOTZoneByOffsetIdxKey) {
			return( (CFSecBuffISOTZoneByOffsetIdxKey)key );
		}
		else {
			CFSecBuffISOTZoneByOffsetIdxKey mapped = new CFSecBuffISOTZoneByOffsetIdxKey();
			mapped.setRequiredTZHourOffset( key.getRequiredTZHourOffset() );
			mapped.setRequiredTZMinOffset( key.getRequiredTZMinOffset() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOTZoneByUTZNameIdxKey newByUTZNameIdxKey() {
		ICFSecISOTZoneByUTZNameIdxKey key =
			new CFSecBuffISOTZoneByUTZNameIdxKey();
		return( key );
	}

	public CFSecBuffISOTZoneByUTZNameIdxKey ensureByUTZNameIdxKey(ICFSecISOTZoneByUTZNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOTZoneByUTZNameIdxKey) {
			return( (CFSecBuffISOTZoneByUTZNameIdxKey)key );
		}
		else {
			CFSecBuffISOTZoneByUTZNameIdxKey mapped = new CFSecBuffISOTZoneByUTZNameIdxKey();
			mapped.setRequiredTZName( key.getRequiredTZName() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOTZoneByIso8601IdxKey newByIso8601IdxKey() {
		ICFSecISOTZoneByIso8601IdxKey key =
			new CFSecBuffISOTZoneByIso8601IdxKey();
		return( key );
	}

	public CFSecBuffISOTZoneByIso8601IdxKey ensureByIso8601IdxKey(ICFSecISOTZoneByIso8601IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffISOTZoneByIso8601IdxKey) {
			return( (CFSecBuffISOTZoneByIso8601IdxKey)key );
		}
		else {
			CFSecBuffISOTZoneByIso8601IdxKey mapped = new CFSecBuffISOTZoneByIso8601IdxKey();
			mapped.setRequiredIso8601( key.getRequiredIso8601() );
			return( mapped );
		}
	}

	@Override
	public ICFSecISOTZone newRec() {
		ICFSecISOTZone rec =
			new CFSecBuffISOTZone();
		return( rec );
	}

	public CFSecBuffISOTZone ensureRec(ICFSecISOTZone rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffISOTZone) {
			return( (CFSecBuffISOTZone)rec );
		}
		else {
			CFSecBuffISOTZone mapped = new CFSecBuffISOTZone();
			mapped.set(rec);
			return( mapped );
		}
	}

	@Override
	public ICFSecISOTZoneH newHRec() {
		ICFSecISOTZoneH hrec =
			new CFSecBuffISOTZoneH();
		return( hrec );
	}

	public CFSecBuffISOTZoneH ensureHRec(ICFSecISOTZoneH hrec) {
		if (hrec == null) {
			return( null );
		}
		else if( hrec instanceof CFSecBuffISOTZoneH) {
			return( (CFSecBuffISOTZoneH)hrec );
		}
		else {
			CFSecBuffISOTZoneH mapped = new CFSecBuffISOTZoneH();
			mapped.set(hrec);
			return( mapped );
		}
	}
}
