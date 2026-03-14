// Description: Java 25 implementation of a ISOCtryCcy buffer

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

public class CFSecBuffISOCtryCcy
	implements ICFSecISOCtryCcy, Comparable<Object>, Serializable
{
	protected ICFSecISOCtryCcyPKey pkey = new CFSecBuffISOCtryCcyPKey();
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtryCcy.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOCtryCcy.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();

	public CFSecBuffISOCtryCcy() {
		pkey = new CFSecBuffISOCtryCcyPKey();
	}

	@Override
	public ICFSecISOCtryCcyPKey getPKey() {
		return pkey;
	}

	@Override
	public void setPKey(ICFSecISOCtryCcyPKey pkey ) {
		if (pkey == null) {
			throw new CFLibNullArgumentException(getClass(), "setPKey", 1, "pkey");
		}
		else if (!(pkey instanceof CFSecBuffISOCtryCcyPKey)) {
			throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffISOCtryCcyPKey");
		}
		this.pkey = (CFSecBuffISOCtryCcyPKey)pkey;
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
	public ICFSecISOCcy getRequiredParentCcy() {
		return( getPKey().getRequiredParentCcy() );
	}
	
	@Override
	public void setRequiredParentCcy(ICFSecISOCcy value) {
		getPKey().setRequiredParentCcy(value);
	}

	@Override
	public void setRequiredParentCcy(short argISOCcyId) {
		getPKey().setRequiredParentCcy(argISOCcyId);
	}

	@Override
	public short getRequiredISOCcyId() {
		return (getPKey().getRequiredParentCcy().getRequiredISOCcyId());
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
		return( ICFSecISOCtryCcy.CLASS_CODE );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecISOCtryCcy ) {
			ICFSecISOCtryCcy rhs = (ICFSecISOCtryCcy)obj;
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
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryCcyH ) {
			ICFSecISOCtryCcyH rhs = (ICFSecISOCtryCcyH)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryCcyHPKey ) {
			ICFSecISOCtryCcyHPKey rhs = (ICFSecISOCtryCcyHPKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryCcyByCtryIdxKey ) {
			ICFSecISOCtryCcyByCtryIdxKey rhs = (ICFSecISOCtryCcyByCtryIdxKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if( obj instanceof ICFSecISOCtryCcyByCcyIdxKey ) {
			ICFSecISOCtryCcyByCcyIdxKey rhs = (ICFSecISOCtryCcyByCcyIdxKey)obj;
			if( getRequiredISOCcyId() != rhs.getRequiredISOCcyId() ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCcyId();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecISOCtryCcy ) {
			ICFSecISOCtryCcy rhs = (ICFSecISOCtryCcy)obj;
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
			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryCcyHPKey ) {
			ICFSecISOCtryCcyHPKey rhs = (ICFSecISOCtryCcyHPKey)obj;
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
			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryCcyH ) {
			ICFSecISOCtryCcyH rhs = (ICFSecISOCtryCcyH)obj;
			cmp = 0;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
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
		else if( obj instanceof ICFSecISOCtryCcyByCtryIdxKey ) {
			ICFSecISOCtryCcyByCtryIdxKey rhs = (ICFSecISOCtryCcyByCtryIdxKey)obj;

			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecISOCtryCcyByCcyIdxKey ) {
			ICFSecISOCtryCcyByCcyIdxKey rhs = (ICFSecISOCtryCcyByCcyIdxKey)obj;

			if( getRequiredISOCcyId() < rhs.getRequiredISOCcyId() ) {
				return( -1 );
			}
			else if( getRequiredISOCcyId() > rhs.getRequiredISOCcyId() ) {
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
	public void set( ICFSecISOCtryCcy src ) {
		setISOCtryCcy( src );
	}

	@Override
	public void setISOCtryCcy( ICFSecISOCtryCcy src ) {
		setRequiredContainerCtry(src.getRequiredContainerCtry());
		setRequiredParentCcy(src.getRequiredParentCcy());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void set( ICFSecISOCtryCcyH src ) {
		setISOCtryCcy( src );
	}

	@Override
	public void setISOCtryCcy( ICFSecISOCtryCcyH src ) {
		setRequiredContainerCtry(src.getRequiredISOCtryId());
		setRequiredParentCcy(src.getRequiredISOCcyId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\""
			+ " RequiredISOCcyId=" + "\"" + Short.toString( getRequiredISOCcyId() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffISOCtryCcy" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
