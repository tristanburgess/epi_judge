package count_bits

func CountBits(x int32) int16 {
	var c int16 = 0

	for x != 0 {
		c += 1
		x &= (x - 1)
	}

	return c
}

func CountBitsCached(x int32) int16 {
	c := make([]int16, 256)
	for i := range c {
		c[i] = CountBits(int32(i))
	}

	return int16(
		c[(x>>24)&0xFF] +
			c[(x>>16)&0xFF] +
			c[(x>>8)&0xFF] +
			c[x&0xFF],
	)
}
