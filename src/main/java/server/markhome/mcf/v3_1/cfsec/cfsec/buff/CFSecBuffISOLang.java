// Description: Java 25 implementation of a ISOLang buffer

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

public class CFSecBuffISOLang
	implements ICFSecISOLang, Comparable<Object>, Serializable
{
	protected short requiredISOLangId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOLang.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOLang.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredISO6392Code;
	protected String optionalISO6391Code;
	protected String requiredEnglishName;

	public CFSecBuffISOLang() {
		requiredISOLangId = ICFSecISOLang.ISOLANGID_INIT_VALUE;
		requiredISO6392Code = ICFSecISOLang.ISO6392CODE_INIT_VALUE;
		optionalISO6391Code = null;
		requiredEnglishName = ICFSecISOLang.ENGLISHNAME_INIT_VALUE;
	}

	@Override
	public Short getPKey() {
		return getRequiredISOLangId();
	}

	@Override
	public void setPKey(Short requiredISOLangId) {
		if (requiredISOLangId != null) {
			setRequiredISOLangId(requiredISOLangId);
		}
	}

	@Override
	public short getRequiredISOLangId() {
		return( requiredISOLangId );
	}

	@Override
	public void setRequiredISOLangId( short value ) {
		if( value < ICFSecISOLang.ISOLANGID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredISOLangId",
				1,
				"value",
				value,
				ICFSecISOLang.ISOLANGID_MIN_VALUE );
		}
		requiredISOLangId = value;
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
		return( ICFSecISOLang.CLASS_CODE );
	}

	@Override
	public List<ICFSecISOCtryLang> getOptionalChildrenCtry() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryLangTable targetTable = targetBackingSchema.getTableISOCtryLang();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtryLang()");
		}
		ICFSecISOCtryLang[] targetArr = targetTable.readDerivedByLangIdx(null, getRequiredISOLangId());
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
	public String getRequiredISO6392Code() {
		return( requiredISO6392Code );
	}

	@Override
	public void setRequiredISO6392Code( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredISO6392Code",
				1,
				"value" );
		}
		else if( value.length() > 3 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredISO6392Code",
				1,
				"value.length()",
				value.length(),
				3 );
		}
		requiredISO6392Code = value;
	}

	@Override
	public String getOptionalISO6391Code() {
		return( optionalISO6391Code );
	}

	@Override
	public void setOptionalISO6391Code( String value ) {
		if( value != null && value.length() > 2 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalISO6391Code",
				1,
				"value.length()",
				value.length(),
				2 );
		}
		optionalISO6391Code = value;
	}

	@Override
	public String getRequiredEnglishName() {
		return( requiredEnglishName );
	}

	@Override
	public void setRequiredEnglishName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredEnglishName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredEnglishName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredEnglishName = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecISOLang ) {
			ICFSecISOLang rhs = (ICFSecISOLang)obj;
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
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			if( getRequiredISO6392Code() != null ) {
				if( rhs.getRequiredISO6392Code() != null ) {
					if( ! getRequiredISO6392Code().equals( rhs.getRequiredISO6392Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISO6392Code() != null ) {
					return( false );
				}
			}
			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					if( ! getOptionalISO6391Code().equals( rhs.getOptionalISO6391Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
					return( false );
				}
			}
			if( getRequiredEnglishName() != null ) {
				if( rhs.getRequiredEnglishName() != null ) {
					if( ! getRequiredEnglishName().equals( rhs.getRequiredEnglishName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnglishName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOLangH ) {
			ICFSecISOLangH rhs = (ICFSecISOLangH)obj;
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			if( getRequiredISO6392Code() != null ) {
				if( rhs.getRequiredISO6392Code() != null ) {
					if( ! getRequiredISO6392Code().equals( rhs.getRequiredISO6392Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISO6392Code() != null ) {
					return( false );
				}
			}
			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					if( ! getOptionalISO6391Code().equals( rhs.getOptionalISO6391Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
					return( false );
				}
			}
			if( getRequiredEnglishName() != null ) {
				if( rhs.getRequiredEnglishName() != null ) {
					if( ! getRequiredEnglishName().equals( rhs.getRequiredEnglishName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnglishName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOLangHPKey ) {
			ICFSecISOLangHPKey rhs = (ICFSecISOLangHPKey)obj;
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOLangByCode3IdxKey ) {
			ICFSecISOLangByCode3IdxKey rhs = (ICFSecISOLangByCode3IdxKey)obj;
			if( getRequiredISO6392Code() != null ) {
				if( rhs.getRequiredISO6392Code() != null ) {
					if( ! getRequiredISO6392Code().equals( rhs.getRequiredISO6392Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISO6392Code() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOLangByCode2IdxKey ) {
			ICFSecISOLangByCode2IdxKey rhs = (ICFSecISOLangByCode2IdxKey)obj;
			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					if( ! getOptionalISO6391Code().equals( rhs.getOptionalISO6391Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOLangId();
		if( getRequiredISO6392Code() != null ) {
			hashCode = hashCode + getRequiredISO6392Code().hashCode();
		}
		if( getOptionalISO6391Code() != null ) {
			hashCode = hashCode + getOptionalISO6391Code().hashCode();
		}
		if( getRequiredEnglishName() != null ) {
			hashCode = hashCode + getRequiredEnglishName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecISOLang ) {
			ICFSecISOLang rhs = (ICFSecISOLang)obj;
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
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			if (getRequiredISO6392Code() != null) {
				if (rhs.getRequiredISO6392Code() != null) {
					cmp = getRequiredISO6392Code().compareTo( rhs.getRequiredISO6392Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISO6392Code() != null) {
				return( -1 );
			}
			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					cmp = getOptionalISO6391Code().compareTo( rhs.getOptionalISO6391Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
					return( -1 );
				}
			}
			if (getRequiredEnglishName() != null) {
				if (rhs.getRequiredEnglishName() != null) {
					cmp = getRequiredEnglishName().compareTo( rhs.getRequiredEnglishName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnglishName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOLangHPKey ) {
			ICFSecISOLangHPKey rhs = (ICFSecISOLangHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
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
		else if( obj instanceof ICFSecISOLangH ) {
			ICFSecISOLangH rhs = (ICFSecISOLangH)obj;
			cmp = 0;
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			if (getRequiredISO6392Code() != null) {
				if (rhs.getRequiredISO6392Code() != null) {
					cmp = getRequiredISO6392Code().compareTo( rhs.getRequiredISO6392Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISO6392Code() != null) {
				return( -1 );
			}
			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					cmp = getOptionalISO6391Code().compareTo( rhs.getOptionalISO6391Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
					return( -1 );
				}
			}
			if (getRequiredEnglishName() != null) {
				if (rhs.getRequiredEnglishName() != null) {
					cmp = getRequiredEnglishName().compareTo( rhs.getRequiredEnglishName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnglishName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOLangByCode3IdxKey ) {
			ICFSecISOLangByCode3IdxKey rhs = (ICFSecISOLangByCode3IdxKey)obj;

			if (getRequiredISO6392Code() != null) {
				if (rhs.getRequiredISO6392Code() != null) {
					cmp = getRequiredISO6392Code().compareTo( rhs.getRequiredISO6392Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISO6392Code() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecISOLangByCode2IdxKey ) {
			ICFSecISOLangByCode2IdxKey rhs = (ICFSecISOLangByCode2IdxKey)obj;

			if( getOptionalISO6391Code() != null ) {
				if( rhs.getOptionalISO6391Code() != null ) {
					cmp = getOptionalISO6391Code().compareTo( rhs.getOptionalISO6391Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalISO6391Code() != null ) {
					return( -1 );
				}
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
	public void set( ICFSecISOLang src ) {
		setISOLang( src );
	}

	@Override
	public void setISOLang( ICFSecISOLang src ) {
		setRequiredISOLangId(src.getRequiredISOLangId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredISO6392Code(src.getRequiredISO6392Code());
		setOptionalISO6391Code(src.getOptionalISO6391Code());
		setRequiredEnglishName(src.getRequiredEnglishName());
	}

	@Override
	public void set( ICFSecISOLangH src ) {
		setISOLang( src );
	}

	@Override
	public void setISOLang( ICFSecISOLangH src ) {
		setRequiredISOLangId(src.getRequiredISOLangId());
		setRequiredISO6392Code(src.getRequiredISO6392Code());
		setOptionalISO6391Code(src.getOptionalISO6391Code());
		setRequiredEnglishName(src.getRequiredEnglishName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredISOLangId=" + "\"" + Short.toString( getRequiredISOLangId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOLangId=" + "\"" + Short.toString( getRequiredISOLangId() ) + "\""
			+ " RequiredISO6392Code=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredISO6392Code() ) + "\""
			+ " OptionalISO6391Code=" + ( ( getOptionalISO6391Code() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalISO6391Code() ) + "\"" )
			+ " RequiredEnglishName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnglishName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffISOLang" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
