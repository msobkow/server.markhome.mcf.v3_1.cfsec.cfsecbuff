// Description: Java 25 implementation of a ISOCtryLang buffer

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

public class CFSecBuffISOCtryLang
	implements ICFSecISOCtryLang, Comparable<Object>, Serializable
{
	protected ICFSecISOCtryLangPKey pkey = new CFSecBuffISOCtryLangPKey();
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtryLang.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtryLang.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();

	public CFSecBuffISOCtryLang() {
		pkey = new CFSecBuffISOCtryLangPKey();
	}

	@Override
	public ICFSecISOCtryLangPKey getPKey() {
		return pkey;
	}

	@Override
	public void setPKey(ICFSecISOCtryLangPKey pkey ) {
		if (pkey == null) {
			throw new CFLibNullArgumentException(getClass(), "setPKey", 1, "pkey");
		}
		else if (!(pkey instanceof CFSecBuffISOCtryLangPKey)) {
			throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffISOCtryLangPKey");
		}
		this.pkey = (CFSecBuffISOCtryLangPKey)pkey;
	}

	@Override
	public ICFSecISOCtry getRequiredContainerCtry() {
		return( getPKey().getRequiredContainerCtry() );
	}
	
	@Override
	public void setRequiredContainerCtry(ICFSecISOCtry value) {
		getPKey().setRequiredContainerCtry(value);
	}

	@Override
	public void setRequiredContainerCtry(short argISOCtryId) {
		getPKey().setRequiredContainerCtry(argISOCtryId);
	}

	@Override
	public short getRequiredISOCtryId() {
		return (getPKey().getRequiredContainerCtry().getRequiredISOCtryId());
	}

	@Override
	public ICFSecISOLang getRequiredParentLang() {
		return( getPKey().getRequiredParentLang() );
	}
	
	@Override
	public void setRequiredParentLang(ICFSecISOLang value) {
		getPKey().setRequiredParentLang(value);
	}

	@Override
	public void setRequiredParentLang(short argISOLangId) {
		getPKey().setRequiredParentLang(argISOLangId);
	}

	@Override
	public short getRequiredISOLangId() {
		return (getPKey().getRequiredParentLang().getRequiredISOLangId());
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
		return( ICFSecISOCtryLang.CLASS_CODE );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecISOCtryLang ) {
			ICFSecISOCtryLang rhs = (ICFSecISOCtryLang)obj;
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
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryLangH ) {
			ICFSecISOCtryLangH rhs = (ICFSecISOCtryLangH)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryLangHPKey ) {
			ICFSecISOCtryLangHPKey rhs = (ICFSecISOCtryLangHPKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryLangByCtryIdxKey ) {
			ICFSecISOCtryLangByCtryIdxKey rhs = (ICFSecISOCtryLangByCtryIdxKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryLangByLangIdxKey ) {
			ICFSecISOCtryLangByLangIdxKey rhs = (ICFSecISOCtryLangByLangIdxKey)obj;
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOLangId();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecISOCtryLang ) {
			ICFSecISOCtryLang rhs = (ICFSecISOCtryLang)obj;
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
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryLangHPKey ) {
			ICFSecISOCtryLangHPKey rhs = (ICFSecISOCtryLangHPKey)obj;
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
			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryLangH ) {
			ICFSecISOCtryLangH rhs = (ICFSecISOCtryLangH)obj;
			cmp = 0;
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
		else if( obj instanceof ICFSecISOCtryLangByCtryIdxKey ) {
			ICFSecISOCtryLangByCtryIdxKey rhs = (ICFSecISOCtryLangByCtryIdxKey)obj;

			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryLangByLangIdxKey ) {
			ICFSecISOCtryLangByLangIdxKey rhs = (ICFSecISOCtryLangByLangIdxKey)obj;

			if( getRequiredISOLangId() < rhs.getRequiredISOLangId() ) {
				return( -1 );
			}
			else if( getRequiredISOLangId() > rhs.getRequiredISOLangId() ) {
				return( 1 );
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
	public void set( ICFSecISOCtryLang src ) {
		setISOCtryLang( src );
	}

	@Override
	public void setISOCtryLang( ICFSecISOCtryLang src ) {
		setRequiredContainerCtry(src.getRequiredContainerCtry());
		setRequiredParentLang(src.getRequiredParentLang());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void set( ICFSecISOCtryLangH src ) {
		setISOCtryLang( src );
	}

	@Override
	public void setISOCtryLang( ICFSecISOCtryLangH src ) {
		setRequiredContainerCtry(src.getRequiredISOCtryId());
		setRequiredParentLang(src.getRequiredISOLangId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredISOLangId=" + "\"" + Short.toString( getRequiredISOLangId() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffISOCtryLang" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
