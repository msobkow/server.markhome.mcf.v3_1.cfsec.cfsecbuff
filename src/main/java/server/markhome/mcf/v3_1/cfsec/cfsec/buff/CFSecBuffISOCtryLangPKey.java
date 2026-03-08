// Description: Java 25 implementation of a ISOCtryLang primary key buffer object

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
import java.io.*;
import java.math.*;
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
 *	CFSecBuffISOCtryLangPKey Primary Key for ISOCtryLang buffers
 *		requiredISOCtryId	Required object attribute ISOCtryId.
 *		requiredISOLangId	Required object attribute ISOLangId.
 */
public class CFSecBuffISOCtryLangPKey
	implements ICFSecISOCtryLangPKey, Comparable<ICFSecISOCtryLangPKey>, Serializable
{
	protected short requiredISOCtryId;
	protected short requiredISOLangId;

	public CFSecBuffISOCtryLangPKey() {
		requiredISOCtryId = ICFSecISOCtryLang.ISOCTRYID_INIT_VALUE;
		requiredISOLangId = ICFSecISOCtryLang.ISOLANGID_INIT_VALUE;
	}

	@Override
	public ICFSecISOCtry getRequiredContainerCtry() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryTable targetTable = targetBackingSchema.getTableISOCtry();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtry()");
		}
		ICFSecISOCtry targetRec = targetTable.readDerived(null, getRequiredISOCtryId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerCtry(ICFSecISOCtry argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerCtry", 1, "argObj");
		}
		else {
			requiredISOCtryId = argObj.getRequiredISOCtryId();
		}
	
	}

	@Override
	public void setRequiredContainerCtry(short argISOCtryId) {
		requiredISOCtryId = argISOCtryId;
	}
	@Override
	public ICFSecISOLang getRequiredParentLang() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOLangTable targetTable = targetBackingSchema.getTableISOLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentLang", 0, "ICFSecSchema.getBackingCFSec().getTableISOLang()");
		}
		ICFSecISOLang targetRec = targetTable.readDerived(null, getRequiredISOLangId());
		return(targetRec);
	}
	@Override
	public void setRequiredParentLang(ICFSecISOLang argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setParentLang", 1, "argObj");
		}
		else {
			requiredISOLangId = argObj.getRequiredISOLangId();
		}
	
	}

	@Override
	public void setRequiredParentLang(short argISOLangId) {
		requiredISOLangId = argISOLangId;
	}
	@Override
	public short getRequiredISOCtryId() {
		return( requiredISOCtryId );
	}

	@Override
	public short getRequiredISOLangId() {
		return( requiredISOLangId );
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ICFSecISOCtryLangPKey) {
			ICFSecISOCtryLangPKey rhs = (ICFSecISOCtryLangPKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCtryId();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOLangId();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( ICFSecISOCtryLangPKey rhs ) {
		int cmp;
		if (rhs == null) {
			return( 1 );
		}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
		return( 0 );
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredISOLangId=" + "\"" + Short.toString( getRequiredISOLangId() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecISOCtryLangPKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
