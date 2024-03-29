//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.2
//
// <auto-generated>
//
// Generated from file `Helper.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package helper;

public class SensorData implements Cloneable,
                                   java.io.Serializable
{
    public String username;

    public String location;

    public int temperature;

    public int aqi;

    public SensorData()
    {
        this.username = "";
        this.location = "";
    }

    public SensorData(String username, String location, int temperature, int aqi)
    {
        this.username = username;
        this.location = location;
        this.temperature = temperature;
        this.aqi = aqi;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        SensorData r = null;
        if(rhs instanceof SensorData)
        {
            r = (SensorData)rhs;
        }

        if(r != null)
        {
            if(this.username != r.username)
            {
                if(this.username == null || r.username == null || !this.username.equals(r.username))
                {
                    return false;
                }
            }
            if(this.location != r.location)
            {
                if(this.location == null || r.location == null || !this.location.equals(r.location))
                {
                    return false;
                }
            }
            if(this.temperature != r.temperature)
            {
                return false;
            }
            if(this.aqi != r.aqi)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::helper::SensorData");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, username);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, location);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, temperature);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, aqi);
        return h_;
    }

    public SensorData clone()
    {
        SensorData c = null;
        try
        {
            c = (SensorData)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.username);
        ostr.writeString(this.location);
        ostr.writeInt(this.temperature);
        ostr.writeInt(this.aqi);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.username = istr.readString();
        this.location = istr.readString();
        this.temperature = istr.readInt();
        this.aqi = istr.readInt();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, SensorData v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public SensorData ice_read(com.zeroc.Ice.InputStream istr)
    {
        SensorData v = new SensorData();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<SensorData> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, SensorData v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<SensorData> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(SensorData.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final SensorData _nullMarshalValue = new SensorData();

    /** @hidden */
    public static final long serialVersionUID = 1327601813L;
}
