// Description: Java 25 implementation of a ISOLang history buffer object

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
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFSecBuffISOLangH
    implements ICFSecISOLangH, Comparable<Object>, Serializable
{
    protected CFSecBuffISOLangHPKey pkey;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOLang.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecISOLang.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredISO6392Code;
	protected String optionalISO6391Code;
	protected String requiredEnglishName;

    public CFSecBuffISOLangH() {
            // The primary key member attributes are initialized on construction
            pkey = new CFSecBuffISOLangHPKey();
		requiredISO6392Code = ICFSecISOLang.ISO6392CODE_INIT_VALUE;
		optionalISO6391Code = null;
		requiredEnglishName = ICFSecISOLang.ENGLISHNAME_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( ICFSecISOLang.CLASS_CODE );
    }

    @Override
    public CFLibDbKeyHash256 getCreatedByUserId() {
        return( createdByUserId );
    }

    @Override
    public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
        }
        createdByUserId = value;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return( createdAt );
    }

    @Override
    public void setCreatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedAt", 1, "value");
        }
        createdAt = value;
    }

    @Override
    public CFLibDbKeyHash256 getUpdatedByUserId() {
        return( updatedByUserId );
    }

    @Override
    public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
        }
        updatedByUserId = value;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return( updatedAt );
    }

    @Override
    public void setUpdatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
        }
        updatedAt = value;
    }

    @Override
    public ICFSecISOLangHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( ICFSecISOLangHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof CFSecBuffISOLangHPKey) {
                this.pkey = (CFSecBuffISOLangHPKey)pkey;
            }
            else {
                throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffISOLangHPKey");
            }
        }
    }

    @Override
    public CFLibDbKeyHash256 getAuditClusterId() {
        return pkey.getAuditClusterId();
    }

    @Override
    public void setAuditClusterId(CFLibDbKeyHash256 auditClusterId) {
        pkey.setAuditClusterId(auditClusterId);
    }

    @Override
    public LocalDateTime getAuditStamp() {
        return pkey.getAuditStamp();
    }

    @Override
    public void setAuditStamp(LocalDateTime auditStamp) {
        pkey.setAuditStamp(auditStamp);
    }

    @Override
    public short getAuditActionId() {
        return pkey.getAuditActionId();
    }

    @Override
    public void setAuditActionId(short auditActionId) {
        pkey.setAuditActionId(auditActionId);
    }

    @Override
    public int getRequiredRevision() {
        return pkey.getRequiredRevision();
    }

    @Override
    public void setRequiredRevision(int revision) {
        pkey.setRequiredRevision(revision);
    }

    @Override
    public CFLibDbKeyHash256 getAuditSessionId() {
        return pkey.getAuditSessionId();
    }

    @Override
    public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId) {
        pkey.setAuditSessionId(auditSessionId);
    }

    @Override
    public short getRequiredISOLangId() {
        return( pkey.getRequiredISOLangId() );
    }

    @Override
    public void setRequiredISOLangId( short requiredISOLangId ) {
        pkey.setRequiredISOLangId( requiredISOLangId );
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
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof ICFSecISOLang) {
            ICFSecISOLang rhs = (ICFSecISOLang)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
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
        else if (obj instanceof ICFSecISOLangH) {
            ICFSecISOLangH rhs = (ICFSecISOLangH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
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
        else if (obj instanceof ICFSecISOLangHPKey) {
		ICFSecISOLangHPKey rhs = (ICFSecISOLangHPKey)obj;
			if( getRequiredISOLangId() != rhs.getRequiredISOLangId() ) {
				return( false );
			}
		return( true );
        }
        else if (obj instanceof ICFSecISOLangByCode3IdxKey) {
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
        else if (obj instanceof ICFSecISOLangByCode2IdxKey) {
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
			return( false );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = pkey.hashCode();
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
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof ICFSecISOLang) {
		ICFSecISOLang rhs = (ICFSecISOLang)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
        else if (obj instanceof ICFSecISOLangHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof ICFSecISOLangH) {
		ICFSecISOLangH rhs = (ICFSecISOLangH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
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
        else if (obj instanceof ICFSecISOLangByCode3IdxKey ) {
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
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecISOLangByCode2IdxKey ) {
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
			}
            return( 0 );
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
		setRequiredISOLangId( src.getRequiredISOLangId() );
		setRequiredISO6392Code( src.getRequiredISO6392Code() );
		setOptionalISO6391Code( src.getOptionalISO6391Code() );
		setRequiredEnglishName( src.getRequiredEnglishName() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( ICFSecISOLangH src ) {
		setISOLang( src );
    }

	@Override
    public void setISOLang( ICFSecISOLangH src ) {
		setRequiredISOLangId( src.getRequiredISOLangId() );
		setRequiredISO6392Code( src.getRequiredISO6392Code() );
		setOptionalISO6391Code( src.getOptionalISO6391Code() );
		setRequiredEnglishName( src.getRequiredEnglishName() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredISO6392Code=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredISO6392Code() ) + "\""
			+ " OptionalISO6391Code=" + ( ( getOptionalISO6391Code() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalISO6391Code() ) + "\"" )
			+ " RequiredEnglishName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnglishName() ) + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<CFSecBuffISOLangH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
