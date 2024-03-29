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

public class WeatherData implements Cloneable,
                                    java.io.Serializable
{
    public String weather;

    public WeatherData()
    {
        this.weather = "";
    }

    public WeatherData(String weather)
    {
        this.weather = weather;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        WeatherData r = null;
        if(rhs instanceof WeatherData)
        {
            r = (WeatherData)rhs;
        }

        if(r != null)
        {
            if(this.weather != r.weather)
            {
                if(this.weather == null || r.weather == null || !this.weather.equals(r.weather))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::helper::WeatherData");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, weather);
        return h_;
    }

    public WeatherData clone()
    {
        WeatherData c = null;
        try
        {
            c = (WeatherData)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.weather);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.weather = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, WeatherData v)
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

    static public WeatherData ice_read(com.zeroc.Ice.InputStream istr)
    {
        WeatherData v = new WeatherData();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<WeatherData> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, WeatherData v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<WeatherData> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(WeatherData.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final WeatherData _nullMarshalValue = new WeatherData();

    /** @hidden */
    public static final long serialVersionUID = -2081868870L;
}
