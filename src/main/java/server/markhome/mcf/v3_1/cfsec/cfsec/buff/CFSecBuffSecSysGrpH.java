// Description: Java 25 implementation of a SecSysGrp history buffer object

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

public class CFSecBuffSecSysGrpH
    implements ICFSecSecSysGrpH, Comparable<Object>, Serializable
{
    protected CFSecBuffSecSysGrpHPKey pkey;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecSysGrp.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecSysGrp.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredName;
	protected ICFSecSchema.SecLevelEnum requiredSecLevel;

    public CFSecBuffSecSysGrpH() {
            // The primary key member attributes are initialized on construction
            pkey = new CFSecBuffSecSysGrpHPKey();
		requiredName = ICFSecSecSysGrp.NAME_INIT_VALUE;
		requiredSecLevel = ICFSecSecSysGrp.SECLEVEL_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( ICFSecSecSysGrp.CLASS_CODE );
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
    public ICFSecSecSysGrpHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( ICFSecSecSysGrpHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof CFSecBuffSecSysGrpHPKey) {
                this.pkey = (CFSecBuffSecSysGrpHPKey)pkey;
            }
            else {
                throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffSecSysGrpHPKey");
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
    public CFLibDbKeyHash256 getRequiredSecSysGrpId() {
        return( pkey.getRequiredSecSysGrpId() );
    }

    @Override
    public void setRequiredSecSysGrpId( CFLibDbKeyHash256 requiredSecSysGrpId ) {
        pkey.setRequiredSecSysGrpId( requiredSecSysGrpId );
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
	public ICFSecSchema.SecLevelEnum getRequiredSecLevel() {
		return( requiredSecLevel );
	}

	@Override
	public void setRequiredSecLevel( ICFSecSchema.SecLevelEnum value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredSecLevel",
				1,
				"value" );
		}
		requiredSecLevel = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof ICFSecSecSysGrp) {
            ICFSecSecSysGrp rhs = (ICFSecSecSysGrp)obj;
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
			if( getRequiredSecLevel() != null ) {
				if( rhs.getRequiredSecLevel() != null ) {
					if( ! getRequiredSecLevel().equals( rhs.getRequiredSecLevel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecLevel() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecSysGrpH) {
            ICFSecSecSysGrpH rhs = (ICFSecSecSysGrpH)obj;
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
			if( getRequiredSecLevel() != null ) {
				if( rhs.getRequiredSecLevel() != null ) {
					if( ! getRequiredSecLevel().equals( rhs.getRequiredSecLevel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecLevel() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecSysGrpHPKey) {
		ICFSecSecSysGrpHPKey rhs = (ICFSecSecSysGrpHPKey)obj;
			if( getRequiredSecSysGrpId() != null ) {
				if( rhs.getRequiredSecSysGrpId() != null ) {
					if( ! getRequiredSecSysGrpId().equals( rhs.getRequiredSecSysGrpId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysGrpId() != null ) {
					return( false );
				}
			}
		return( true );
        }
        else if (obj instanceof ICFSecSecSysGrpByUNameIdxKey) {
            ICFSecSecSysGrpByUNameIdxKey rhs = (ICFSecSecSysGrpByUNameIdxKey)obj;
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
        else if (obj instanceof ICFSecSecSysGrpBySecLevelIdxKey) {
            ICFSecSecSysGrpBySecLevelIdxKey rhs = (ICFSecSecSysGrpBySecLevelIdxKey)obj;
			if( getRequiredSecLevel() != null ) {
				if( rhs.getRequiredSecLevel() != null ) {
					if( ! getRequiredSecLevel().equals( rhs.getRequiredSecLevel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecLevel() != null ) {
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
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		hashCode = ( hashCode * 0x10000 ) + getRequiredSecLevel().ordinal();
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof ICFSecSecSysGrp) {
		ICFSecSecSysGrp rhs = (ICFSecSecSysGrp)obj;
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
			if (getRequiredSecLevel() != null) {
				if (rhs.getRequiredSecLevel() != null) {
					cmp = getRequiredSecLevel().compareTo( rhs.getRequiredSecLevel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecLevel() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecSysGrpHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof ICFSecSecSysGrpH) {
		ICFSecSecSysGrpH rhs = (ICFSecSecSysGrpH)obj;
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
			if (getRequiredSecLevel() != null) {
				if (rhs.getRequiredSecLevel() != null) {
					cmp = getRequiredSecLevel().compareTo( rhs.getRequiredSecLevel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecLevel() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecSysGrpByUNameIdxKey ) {
            ICFSecSecSysGrpByUNameIdxKey rhs = (ICFSecSecSysGrpByUNameIdxKey)obj;
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
        else if (obj instanceof ICFSecSecSysGrpBySecLevelIdxKey ) {
            ICFSecSecSysGrpBySecLevelIdxKey rhs = (ICFSecSecSysGrpBySecLevelIdxKey)obj;
			if (getRequiredSecLevel() != null) {
				if (rhs.getRequiredSecLevel() != null) {
					cmp = getRequiredSecLevel().compareTo( rhs.getRequiredSecLevel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecLevel() != null) {
				return( -1 );
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
    public void set( ICFSecSecSysGrp src ) {
		setSecSysGrp( src );
    }

	@Override
    public void setSecSysGrp( ICFSecSecSysGrp src ) {
		setRequiredSecSysGrpId( src.getRequiredSecSysGrpId() );
		setRequiredName( src.getRequiredName() );
		setRequiredSecLevel( src.getRequiredSecLevel() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( ICFSecSecSysGrpH src ) {
		setSecSysGrp( src );
    }

	@Override
    public void setSecSysGrp( ICFSecSecSysGrpH src ) {
		setRequiredSecSysGrpId( src.getRequiredSecSysGrpId() );
		setRequiredName( src.getRequiredName() );
		setRequiredSecLevel( src.getRequiredSecLevel() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " RequiredSecLevel=" + "\"" + getRequiredSecLevel().toString() + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<CFSecBuffSecSysGrpH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
