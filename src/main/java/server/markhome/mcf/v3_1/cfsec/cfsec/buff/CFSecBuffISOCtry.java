// Description: Java 25 implementation of a ISOCtry buffer

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
import java.io.*;
import java.math.*;
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

public class CFSecBuffISOCtry
	implements ICFSecISOCtry, Comparable<Object>, Serializable
{
	protected short requiredISOCtryId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtry.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtry.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredISOCode;
	protected String requiredName;

	public CFSecBuffISOCtry() {
		requiredISOCtryId = ICFSecISOCtry.ISOCTRYID_INIT_VALUE;
		requiredISOCode = ICFSecISOCtry.ISOCODE_INIT_VALUE;
		requiredName = ICFSecISOCtry.NAME_INIT_VALUE;
	}

	@Override
	public Short getPKey() {
		return getRequiredISOCtryId();
	}

	@Override
	public void setPKey(Short requiredISOCtryId) {
		if (requiredISOCtryId != null) {
			setRequiredISOCtryId(requiredISOCtryId);
		}
	}

	@Override
	public short getRequiredISOCtryId() {
		return( requiredISOCtryId );
	}

	@Override
	public void setRequiredISOCtryId( short value ) {
		if( value < ICFSecISOCtry.ISOCTRYID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredISOCtryId",
				1,
				"value",
				value,
				ICFSecISOCtry.ISOCTRYID_MIN_VALUE );
		}
		requiredISOCtryId = value;
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}
	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFSecISOCtry.CLASS_CODE );
	}

	@Override
	public List<ICFSecISOCtryCcy> getOptionalComponentsCcy() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsCcy", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryCcyTable targetTable = targetBackingSchema.getTableISOCtryCcy();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsCcy", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtryCcy()");
		}
		ICFSecISOCtryCcy[] targetArr = targetTable.readDerivedByCtryIdx(null, getRequiredISOCtryId());
		if( targetArr != null ) {
			List<ICFSecISOCtryCcy> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecISOCtryCcy> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecISOCtryLang> getOptionalComponentsLang() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsLang", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryLangTable targetTable = targetBackingSchema.getTableISOCtryLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsLang", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtryLang()");
		}
		ICFSecISOCtryLang[] targetArr = targetTable.readDerivedByCtryIdx(null, getRequiredISOCtryId());
		if( targetArr != null ) {
			List<ICFSecISOCtryLang> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecISOCtryLang> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public String getRequiredISOCode() {
		return( requiredISOCode );
	}

	@Override
	public void setRequiredISOCode( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredISOCode",
				1,
				"value" );
		}
		else if( value.length() > 2 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredISOCode",
				1,
				"value.length()",
				value.length(),
				2 );
		}
		requiredISOCode = value;
	}

	@Override
	public String getRequiredName() {
		return( requiredName );
	}

	@Override
	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecISOCtry ) {
			ICFSecISOCtry rhs = (ICFSecISOCtry)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOCode() != null ) {
				if( rhs.getRequiredISOCode() != null ) {
					if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISOCode() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryH ) {
			ICFSecISOCtryH rhs = (ICFSecISOCtryH)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOCode() != null ) {
				if( rhs.getRequiredISOCode() != null ) {
					if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISOCode() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryHPKey ) {
			ICFSecISOCtryHPKey rhs = (ICFSecISOCtryHPKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryByISOCodeIdxKey ) {
			ICFSecISOCtryByISOCodeIdxKey rhs = (ICFSecISOCtryByISOCodeIdxKey)obj;
			if( getRequiredISOCode() != null ) {
				if( rhs.getRequiredISOCode() != null ) {
					if( ! getRequiredISOCode().equals( rhs.getRequiredISOCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISOCode() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryByNameIdxKey ) {
			ICFSecISOCtryByNameIdxKey rhs = (ICFSecISOCtryByNameIdxKey)obj;
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCtryId();
		if( getRequiredISOCode() != null ) {
			hashCode = hashCode + getRequiredISOCode().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecISOCtry ) {
			ICFSecISOCtry rhs = (ICFSecISOCtry)obj;
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if (getRequiredISOCode() != null) {
				if (rhs.getRequiredISOCode() != null) {
					cmp = getRequiredISOCode().compareTo( rhs.getRequiredISOCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISOCode() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryHPKey ) {
			ICFSecISOCtryHPKey rhs = (ICFSecISOCtryHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryH ) {
			ICFSecISOCtryH rhs = (ICFSecISOCtryH)obj;
			cmp = 0;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			if (getRequiredISOCode() != null) {
				if (rhs.getRequiredISOCode() != null) {
					cmp = getRequiredISOCode().compareTo( rhs.getRequiredISOCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISOCode() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryByISOCodeIdxKey ) {
			ICFSecISOCtryByISOCodeIdxKey rhs = (ICFSecISOCtryByISOCodeIdxKey)obj;

			if (getRequiredISOCode() != null) {
				if (rhs.getRequiredISOCode() != null) {
					cmp = getRequiredISOCode().compareTo( rhs.getRequiredISOCode() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISOCode() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryByNameIdxKey ) {
			ICFSecISOCtryByNameIdxKey rhs = (ICFSecISOCtryByNameIdxKey)obj;

			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFSecISOCtry src ) {
		setISOCtry( src );
	}

	@Override
	public void setISOCtry( ICFSecISOCtry src ) {
		setRequiredISOCtryId(src.getRequiredISOCtryId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredISOCode(src.getRequiredISOCode());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( ICFSecISOCtryH src ) {
		setISOCtry( src );
	}

	@Override
	public void setISOCtry( ICFSecISOCtryH src ) {
		setRequiredISOCtryId(src.getRequiredISOCtryId());
		setRequiredISOCode(src.getRequiredISOCode());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredISOCode=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredISOCode() ) + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffISOCtry" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
