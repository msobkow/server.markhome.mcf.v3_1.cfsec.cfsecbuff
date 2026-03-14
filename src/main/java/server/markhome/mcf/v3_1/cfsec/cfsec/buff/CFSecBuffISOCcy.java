// Description: Java 25 implementation of a ISOCcy buffer

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

public class CFSecBuffISOCcy
	implements ICFSecISOCcy, Comparable<Object>, Serializable
{
	protected short requiredISOCcyId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCcy.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCcy.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredISOCode;
	protected String requiredName;
	protected String optionalUnitSymbol;
	protected short requiredPrecis;

	public CFSecBuffISOCcy() {
		requiredISOCcyId = ICFSecISOCcy.ISOCCYID_INIT_VALUE;
		requiredISOCode = ICFSecISOCcy.ISOCODE_INIT_VALUE;
		requiredName = ICFSecISOCcy.NAME_INIT_VALUE;
		optionalUnitSymbol = null;
		requiredPrecis = ICFSecISOCcy.PRECIS_INIT_VALUE;
	}

	@Override
	public Short getPKey() {
		return getRequiredISOCcyId();
	}

	@Override
	public void setPKey(Short requiredISOCcyId) {
		if (requiredISOCcyId != null) {
			setRequiredISOCcyId(requiredISOCcyId);
		}
	}

	@Override
	public short getRequiredISOCcyId() {
		return( requiredISOCcyId );
	}

	@Override
	public void setRequiredISOCcyId( short value ) {
		if( value < ICFSecISOCcy.ISOCCYID_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredISOCcyId",
				1,
				"value",
				value,
				ICFSecISOCcy.ISOCCYID_MIN_VALUE );
		}
		requiredISOCcyId = value;
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
		return( ICFSecISOCcy.CLASS_CODE );
	}

	@Override
	public List<ICFSecISOCtryCcy> getOptionalChildrenCtry() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenCtry", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecISOCtryCcyTable targetTable = targetBackingSchema.getTableISOCtryCcy();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalChildrenCtry", 0, "ICFSecSchema.getBackingCFSec().getTableISOCtryCcy()");
		}
		ICFSecISOCtryCcy[] targetArr = targetTable.readDerivedByCcyIdx(null, getRequiredISOCcyId());
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
		else if( value.length() > 3 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredISOCode",
				1,
				"value.length()",
				value.length(),
				3 );
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
	public String getOptionalUnitSymbol() {
		return( optionalUnitSymbol );
	}

	@Override
	public void setOptionalUnitSymbol( String value ) {
		if( value != null && value.length() > 4 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setOptionalUnitSymbol",
				1,
				"value.length()",
				value.length(),
				4 );
		}
		optionalUnitSymbol = value;
	}

	@Override
	public short getRequiredPrecis() {
		return( requiredPrecis );
	}

	@Override
	public void setRequiredPrecis( short value ) {
		if( value < ICFSecISOCcy.PRECIS_MIN_VALUE ) {
			throw new CFLibArgumentUnderflowException( getClass(),
				"setRequiredPrecis",
				1,
				"value",
				value,
				ICFSecISOCcy.PRECIS_MIN_VALUE );
		}
		if( value > ICFSecISOCcy.PRECIS_MAX_VALUE ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredPrecis",
				1,
				"value",
				value,
				ICFSecISOCcy.PRECIS_MAX_VALUE );
		}
		requiredPrecis = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecISOCcy ) {
			ICFSecISOCcy rhs = (ICFSecISOCcy)obj;
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
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
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
			if( getOptionalUnitSymbol() != null ) {
				if( rhs.getOptionalUnitSymbol() != null ) {
					if( ! getOptionalUnitSymbol().equals( rhs.getOptionalUnitSymbol() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalUnitSymbol() != null ) {
					return( false );
				}
			}
			if( getRequiredPrecis() != rhs.getRequiredPrecis() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCcyH ) {
			ICFSecISOCcyH rhs = (ICFSecISOCcyH)obj;
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
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
			if( getOptionalUnitSymbol() != null ) {
				if( rhs.getOptionalUnitSymbol() != null ) {
					if( ! getOptionalUnitSymbol().equals( rhs.getOptionalUnitSymbol() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalUnitSymbol() != null ) {
					return( false );
				}
			}
			if( getRequiredPrecis() != rhs.getRequiredPrecis() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCcyHPKey ) {
			ICFSecISOCcyHPKey rhs = (ICFSecISOCcyHPKey)obj;
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCcyByCcyCdIdxKey ) {
			ICFSecISOCcyByCcyCdIdxKey rhs = (ICFSecISOCcyByCcyCdIdxKey)obj;
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
		else if( obj instanceof ICFSecISOCcyByCcyNmIdxKey ) {
			ICFSecISOCcyByCcyNmIdxKey rhs = (ICFSecISOCcyByCcyNmIdxKey)obj;
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCcyId();
		if( getRequiredISOCode() != null ) {
			hashCode = hashCode + getRequiredISOCode().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalUnitSymbol() != null ) {
			hashCode = hashCode + getOptionalUnitSymbol().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredPrecis();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecISOCcy ) {
			ICFSecISOCcy rhs = (ICFSecISOCcy)obj;
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
			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
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
			if( getOptionalUnitSymbol() != null ) {
				if( rhs.getOptionalUnitSymbol() != null ) {
					cmp = getOptionalUnitSymbol().compareTo( rhs.getOptionalUnitSymbol() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalUnitSymbol() != null ) {
					return( -1 );
				}
			}
			if( getRequiredPrecis() < rhs.getRequiredPrecis() ) {
				return( -1 );
			}
			else if( getRequiredPrecis() > rhs.getRequiredPrecis() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCcyHPKey ) {
			ICFSecISOCcyHPKey rhs = (ICFSecISOCcyHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCcyH ) {
			ICFSecISOCcyH rhs = (ICFSecISOCcyH)obj;
			cmp = 0;
			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
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
			if( getOptionalUnitSymbol() != null ) {
				if( rhs.getOptionalUnitSymbol() != null ) {
					cmp = getOptionalUnitSymbol().compareTo( rhs.getOptionalUnitSymbol() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalUnitSymbol() != null ) {
					return( -1 );
				}
			}
			if( getRequiredPrecis() < rhs.getRequiredPrecis() ) {
				return( -1 );
			}
			else if( getRequiredPrecis() > rhs.getRequiredPrecis() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCcyByCcyCdIdxKey ) {
			ICFSecISOCcyByCcyCdIdxKey rhs = (ICFSecISOCcyByCcyCdIdxKey)obj;

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
		else if( obj instanceof ICFSecISOCcyByCcyNmIdxKey ) {
			ICFSecISOCcyByCcyNmIdxKey rhs = (ICFSecISOCcyByCcyNmIdxKey)obj;

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
	public void set( ICFSecISOCcy src ) {
		setISOCcy( src );
	}

	@Override
	public void setISOCcy( ICFSecISOCcy src ) {
		setRequiredISOCcyId(src.getRequiredISOCcyId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredISOCode(src.getRequiredISOCode());
		setRequiredName(src.getRequiredName());
		setOptionalUnitSymbol(src.getOptionalUnitSymbol());
		setRequiredPrecis(src.getRequiredPrecis());
	}

	@Override
	public void set( ICFSecISOCcyH src ) {
		setISOCcy( src );
	}

	@Override
	public void setISOCcy( ICFSecISOCcyH src ) {
		setRequiredISOCcyId(src.getRequiredISOCcyId());
		setRequiredISOCode(src.getRequiredISOCode());
		setRequiredName(src.getRequiredName());
		setOptionalUnitSymbol(src.getOptionalUnitSymbol());
		setRequiredPrecis(src.getRequiredPrecis());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredISOCcyId=" + "\"" + Short.toString( getRequiredISOCcyId() ) + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOCcyId=" + "\"" + Short.toString( getRequiredISOCcyId() ) + "\""
			+ " RequiredISOCode=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredISOCode() ) + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalUnitSymbol=" + ( ( getOptionalUnitSymbol() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalUnitSymbol() ) + "\"" )
			+ " RequiredPrecis=" + "\"" + Short.toString( getRequiredPrecis() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffISOCcy" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
